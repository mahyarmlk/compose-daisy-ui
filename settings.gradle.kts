pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
  }
}

dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositories {
    mavenCentral()
    google()
  }
}

rootProject.name = "compose-daisy-ui"

include(":compose-daisyui-core")
include(":compose-daisyui")
include(":app")
