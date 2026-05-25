import org.gradle.api.tasks.bundling.Zip
import java.util.Base64

plugins {
  kotlin("multiplatform") version "2.3.20" apply false
  kotlin("plugin.compose") version "2.3.20" apply false
  id("org.jetbrains.compose") version "1.11.0" apply false
}

allprojects {
  group = "io.github.mahyarmlk"
  version = "0.1.0"
}

subprojects {
  plugins.withId("maven-publish") {
    tasks.withType<GenerateModuleMetadata>().configureEach { enabled = false }
    extensions.configure<PublishingExtension>("publishing") {
      publications.withType<MavenPublication>().configureEach {
        pom {
          name.set(project.name)
          description.set("Compose HTML components and daisyUI 5 tokens for Kotlin/JS.")
          url.set("https://github.com/mahyarmlk/compose-daisy-ui")
          licenses {
            license {
              name.set("The Apache License, Version 2.0")
              url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
          }
          developers {
            developer {
              id.set("mahyarmlk")
              name.set("Mahyar")
            }
          }
          scm {
            connection.set("scm:git:git://github.com/mahyarmlk/compose-daisy-ui.git")
            developerConnection.set("scm:git:ssh://git@github.com/mahyarmlk/compose-daisy-ui.git")
            url.set("https://github.com/mahyarmlk/compose-daisy-ui")
          }
        }
      }
      repositories {
        maven {
          name = "localStaging"
          url = rootProject.layout.buildDirectory.dir("staging-deploy").get().asFile.toURI()
        }
      }
    }
  }

  plugins.withId("signing") {
    extensions.configure<SigningExtension>("signing") {
      val signingPassword = providers.gradleProperty("signingInMemoryKeyPassword").orNull
      val signingKey = providers.gradleProperty("signingInMemoryKey").orNull
        ?: file("${System.getProperty("user.home")}/.gradle/signing-key.asc").takeIf { it.exists() }?.readText()
      if (!signingKey.isNullOrBlank()) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(project.extensions.getByType<PublishingExtension>().publications)
      }
    }
  }
}

val stagingDir = layout.buildDirectory.dir("staging-deploy")

val publishToLocalStaging = tasks.register("publishToLocalStaging") {
  group = "publishing"
  description = "Publishes JS platform Maven publications to the local staging directory (excludes KMP metadata publications)"
  dependsOn(subprojects.flatMap { it.tasks.matching { it.name.startsWith("publish") && it.name.contains("JsPublicationToLocalStaging") } })
}

val publishToMavenCentral by tasks.register("publishToMavenCentral") {
  group = "publishing"
  description = "Publishes to Maven Central via Sonatype Central Publisher API"
  dependsOn(publishToLocalStaging)

  doLast {
    val username = providers.gradleProperty("mavenCentralUsername").orNull
      ?: throw GradleException("mavenCentralUsername property not set")
    val password = providers.gradleProperty("mavenCentralPassword").orNull
      ?: throw GradleException("mavenCentralPassword property not set")

    val auth = Base64.getEncoder().encodeToString("$username:$password".toByteArray())

    val bundleFile = layout.buildDirectory.file("maven-central-bundle.zip").get().asFile
    bundleFile.parentFile.mkdirs()
    bundleFile.delete()

    ant.withGroovyBuilder {
      "zip"("destfile" to bundleFile.absolutePath) {
        "fileset"("dir" to stagingDir.get().asFile.absolutePath)
      }
    }

    logger.lifecycle("Bundle created: ${bundleFile.absolutePath} (${bundleFile.length()} bytes)")

    val process = ProcessBuilder(
      "curl", "-s", "-w", "%{http_code}",
      "-X", "POST",
      "-H", "Authorization: Bearer $auth",
      "-F", "bundle=@${bundleFile.absolutePath}",
      "https://central.sonatype.com/api/v1/publisher/upload?name=compose-daisy-ui-${version}"
    )
      .redirectErrorStream(true)
      .start()

    val output = process.inputStream.bufferedReader().readText()
    val exitCode = process.waitFor()

    if (exitCode == 0 && output.endsWith("201")) {
      logger.lifecycle("Published to Maven Central successfully")
    } else {
      throw GradleException("Upload failed (exit=$exitCode): $output")
    }
  }
}
