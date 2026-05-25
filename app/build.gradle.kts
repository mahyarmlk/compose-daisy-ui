plugins {
  kotlin("multiplatform")
  kotlin("plugin.compose")
  id("org.jetbrains.compose")
  id("io.github.compose-daisy-ui.webpack")
}

kotlin {
  js(IR) {
    browser {
      runTask {
        devServerProperty.set(devServerProperty.get()?.copy(
          port = 3000,
          open = true
        ))
      }
    }
    binaries.executable()
  }

  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(project(":compose-daisyui"))
        implementation(npm("daisyui", "5.0.27"))
        implementation(npm("tailwindcss", "4.1.18"))
        implementation(npm("@tailwindcss/postcss", "4.1.18"))
        implementation(npm("postcss-import", "16.1.1"))
        implementation(npm("postcss-loader", "8.2.0"))
        implementation(npm("css-loader", "7.1.2"))
        implementation(npm("style-loader", "4.0.0"))
      }
    }
  }
}
