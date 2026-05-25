import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import composedaisyui.DaisyTheme
import composedaisyui.tw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable
import sections.AppNavBar
import sections.HeroSection

fun main() {
  renderComposable(rootElementId = "root") {
    App()
  }
}

@Composable
private fun App() {
  var theme by remember { mutableStateOf(DaisyTheme.Night) }

  Div({
    attr("data-theme", theme.themeName)
    tw("h-screen flex flex-col overflow-hidden")
  }) {
    AppNavBar(currentTheme = theme, onThemeChange = { theme = it })
    HeroSection()
  }
}
