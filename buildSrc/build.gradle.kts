plugins {
  `kotlin-dsl`
}

repositories {
  maven("https://maven.devneeds.ir")
  maven("https://maven.myket.ir")
  gradlePluginPortal()
  mavenCentral()
}

gradlePlugin {
  plugins {
    register("composeDaisyUiWebpack") {
      id = "io.github.compose-daisy-ui.webpack"
      implementationClass = "composedaisyui.gradle.ComposeDaisyUiWebpackPlugin"
    }
  }
}

