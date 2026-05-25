plugins {
  kotlin("multiplatform") version "2.3.20" apply false
  kotlin("plugin.compose") version "2.3.20" apply false
  id("org.jetbrains.compose") version "1.11.0" apply false
}

allprojects {
  group = "io.github.compose-daisy-ui"
  version = "0.1.0"
}

subprojects {
  plugins.withId("maven-publish") {
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
      val signingKey = providers.gradleProperty("signingInMemoryKey").orNull
      val signingPassword = providers.gradleProperty("signingInMemoryKeyPassword").orNull
      if (!signingKey.isNullOrBlank()) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        extensions.configure<PublishingExtension>("publishing") {
          sign(publications)
        }
      }
    }
  }
}
