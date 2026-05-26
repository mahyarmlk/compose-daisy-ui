package sections

import androidx.compose.runtime.Composable
import composedaisyui.DaisyTheme
import composedaisyui.tw
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun AppNavBar(
  currentTheme: DaisyTheme,
  currentPage: AppPage,
  onThemeChange: (DaisyTheme) -> Unit
) {
  Header({ tw("sticky top-0 z-30 border-b border-base-300 bg-base-100/90 backdrop-blur") }) {
    Div({ tw("mx-auto flex h-16 max-w-7xl items-center justify-between gap-4 px-5 sm:px-8 lg:px-10") }) {
      A(
        attrs = {
          href("#")
          tw("btn btn-ghost btn-sm px-2 text-base normal-case")
        }
      ) {
        Div({
          tw(
            "mr-1 flex h-8 w-8 items-center justify-center rounded-field " +
              "bg-primary text-xs font-black text-primary-content"
          )
        }) {
          Text("CD")
        }
        Span({ tw("text-base font-extrabold tracking-tight") }) {
          Text("Compose daisyUI")
        }
      }

      Nav({ tw("hidden items-center gap-1 md:flex") }) {
        A(attrs = {
          href("#components")
          tw("btn btn-ghost btn-sm btn-neutral")
        }) {
          Text("Components")
        }
        A(attrs = {
          href("#docs")
          tw("btn btn-sm btn-neutral ${if (currentPage == AppPage.Docs) "btn-soft" else "btn-ghost"}")
        }) {
          Text("Docs")
        }
      }

      Div({ tw("flex items-center gap-2") }) {
        ThemePicker(currentTheme = currentTheme, onThemeChange = onThemeChange)
        A(attrs = {
          href("https://github.com/mahyarmlk/compose-daisy-ui")
          tw("btn btn-outline btn-sm btn-neutral")
        }) {
          Text("GitHub")
        }
      }
    }
  }
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
