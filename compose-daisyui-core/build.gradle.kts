plugins {
  kotlin("multiplatform")
  kotlin("plugin.compose")
  id("org.jetbrains.compose")
  id("maven-publish")
  id("signing")
}

kotlin {
  js(IR) {
    browser()
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        api(compose.html.core)
        api(compose.runtime)
      }
    }
  }
}
