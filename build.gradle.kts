plugins {
  kotlin("multiplatform") version "2.3.20" apply false
  kotlin("plugin.compose") version "2.3.20" apply false
  id("org.jetbrains.compose") version "1.11.0" apply false
  id("com.vanniktech.maven.publish") version "0.33.0" apply false
}

allprojects {
  group = "io.github.mahyarmlk"
  version = providers.gradleProperty("composeDaisyUiVersion").orElse("0.1.1").get()
}
