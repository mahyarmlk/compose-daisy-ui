plugins {
  kotlin("multiplatform")
  kotlin("plugin.compose")
  id("org.jetbrains.compose")
  id("com.vanniktech.maven.publish")
}

mavenPublishing {
  publishToMavenCentral()
  signAllPublications()

  coordinates(project.group.toString(), project.name, project.version.toString())

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

plugins.withId("signing") {
  val signingKey: String? = providers.gradleProperty("signingInMemoryKey").orNull
    ?: file("${System.getProperty("user.home")}/.gradle/signing-key.asc").takeIf { it.exists() }?.readText()
  val signingPassword: String? = providers.gradleProperty("signingInMemoryKeyPassword").orNull

  if (!signingKey.isNullOrBlank()) {
    extensions.configure<SigningExtension>("signing") {
      useInMemoryPgpKeys(signingKey, signingPassword)
    }
  }
}

afterEvaluate {
  publishing {
    publications {
      withType<MavenPublication>().configureEach {
        if (name == "js") {
          pom.packaging = "jar"
        }
      }
    }
  }
}

kotlin {
  js(IR) {
    browser()
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        api(project(":compose-daisyui-core"))
        api(compose.html.core)
        api(compose.runtime)
      }
    }
  }
}
