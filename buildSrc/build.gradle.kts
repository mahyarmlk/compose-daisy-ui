plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
  mavenCentral()
}

gradlePlugin {
  plugins {
    register("composeDaisyUiWebpack") {
      id = "io.github.mahyarmlk.webpack"
      implementationClass = "io.github.mahyarmlk.gradle.ComposeDaisyUiWebpackPlugin"
    }
  }
}

