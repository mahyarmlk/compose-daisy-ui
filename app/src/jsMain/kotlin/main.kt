import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import composedaisyui.DaisyTheme
import composedaisyui.tw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable
import sections.AppFooter
import sections.AppNavBar
import sections.AppPage
import sections.CtaSection
import sections.DocsPage
import sections.FeaturesSection
import sections.HeroSection
import sections.StatsSection

fun main() {
  renderComposable(rootElementId = "root") {
    App()
  }
}

@Composable
private fun App() {
  var theme by remember { mutableStateOf(DaisyTheme.Night) }
  var page by remember { mutableStateOf(AppPage.Home) }

  Div({
    attr("data-theme", theme.themeName)
    tw("min-h-screen bg-base-100 text-base-content")
  }) {
    AppNavBar(
      currentTheme = theme,
      currentPage = page,
      onThemeChange = { theme = it },
      onNavigate = { page = it }
    )
    Div({ attr("role", "main") }) {
      when (page) {
        AppPage.Home -> {
          HeroSection()
          FeaturesSection()
          StatsSection()
          CtaSection()
        }
        AppPage.Docs -> DocsPage()
      }
    }
    AppFooter()
  }
}
