package sections

import androidx.compose.runtime.Composable
import composedaisyui.DaisyTheme
import composedaisyui.UiColor
import composedaisyui.UiSize
import composedaisyui.UiVariant
import composedaisyui.actions.Button
import composedaisyui.app.TopAppBar
import composedaisyui.tw
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun AppNavBar(
  currentTheme: DaisyTheme,
  onThemeChange: (DaisyTheme) -> Unit
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
        variant = UiVariant.Ghost,
        size = UiSize.Sm,
        color = UiColor.Neutral
      )
      Button(
        text = "GitHub",
        variant = UiVariant.Ghost,
        size = UiSize.Sm
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
    DaisyTheme.entries.forEach { theme ->
      Option(value = theme.themeName, attrs = {
        if (theme == currentTheme) selected()
      }) {
        Text(theme.themeName.replaceFirstChar { it.uppercase() })
      }
    }
  }
}
