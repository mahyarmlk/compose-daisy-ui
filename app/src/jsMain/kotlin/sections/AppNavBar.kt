package sections

import androidx.compose.runtime.Composable
import composedaisyui.DaisyTheme
import composedaisyui.UiColor
import composedaisyui.UiSize
import composedaisyui.UiVariant
import composedaisyui.actions.Button
import composedaisyui.app.TopAppBar
import composedaisyui.tw
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun AppNavBar(
  currentTheme: DaisyTheme,
  currentPage: AppPage,
  onThemeChange: (DaisyTheme) -> Unit,
  onNavigate: (AppPage) -> Unit
) {
  TopAppBar(
    title = "Compose daisyUI",
    attrs = {
      tw("border-b border-base-content/5")
    },
    navigationIcon = {
      Div({
        tw(
          "w-8 h-8 rounded-lg bg-primary/10 " +
            "flex items-center justify-center"
        )
      }) {
        Span({ tw("text-primary font-bold text-xs") }) {
          Text("CD")
        }
      }
    },
    actions = {
      ThemePicker(currentTheme = currentTheme, onThemeChange = onThemeChange)
      Button(
        text = "Documentation",
        variant = if (currentPage == AppPage.Docs) UiVariant.Soft else UiVariant.Ghost,
        size = UiSize.Sm,
        color = UiColor.Neutral,
        onClick = { onNavigate(AppPage.Docs) }
      )
      Button(
        text = "GitHub",
        variant = UiVariant.Ghost,
        size = UiSize.Sm,
        onClick = { window.location.href = "https://github.com/mahyarmlk/compose-daisy-ui" }
      )
    }
  )
}

@Composable
private fun ThemePicker(
  currentTheme: DaisyTheme,
  onThemeChange: (DaisyTheme) -> Unit
) {
  Select(attrs = {
    tw("select select-sm w-32 bg-base-100")
    attr("aria-label", "Theme")
    onChange { event ->
      event.value?.let { value ->
        DaisyTheme.fromThemeName(value)?.let(onThemeChange)
      }
    }
  }) {
    DemoThemes.forEach { theme ->
      Option(value = theme.themeName, attrs = {
        if (theme == currentTheme) selected()
      }) {
        Text(theme.themeName.replaceFirstChar { it.uppercase() })
      }
    }
  }
}

private val DemoThemes = listOf(
  DaisyTheme.Light,
  DaisyTheme.Dark,
  DaisyTheme.Night,
  DaisyTheme.Retro,
  DaisyTheme.Cupcake,
  DaisyTheme.Emerald,
  DaisyTheme.Corporate,
  DaisyTheme.Synthwave
)

public enum class AppPage {
  Home,
  Docs
}
