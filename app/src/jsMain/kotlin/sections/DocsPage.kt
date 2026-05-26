package sections

import androidx.compose.runtime.Composable
import composedaisyui.CardVariant
import composedaisyui.UiColor
import composedaisyui.UiSize
import composedaisyui.UiVariant
import composedaisyui.actions.Button
import composedaisyui.datadisplay.Badge
import composedaisyui.datadisplay.Card
import composedaisyui.misc.Link
import composedaisyui.tw
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul

@Composable
public fun DocsPage() {
  Div({ tw("bg-base-100") }) {
    DocsHero()
    Div({
      tw(
        "mx-auto grid w-full max-w-7xl grid-cols-1 gap-8 px-5 py-10 " +
          "sm:px-8 lg:grid-cols-[260px_minmax(0,1fr)] lg:px-10 lg:py-12"
      )
    }) {
      DocsSidebar()
      Div({ tw("space-y-8") }) {
        QuickStartSection()
        ProjectSetupSection()
        FirstComponentSection()
        ThemingSection()
        ComponentModelSection()
      }
    }
  }
}

@Composable
private fun DocsHero() {
  Div({ tw("border-b border-base-300 bg-base-200") }) {
    Div({ tw("mx-auto flex max-w-7xl flex-col gap-6 px-5 py-12 sm:px-8 lg:px-10") }) {
      Div({ tw("flex flex-wrap items-center gap-2") }) {
        Badge(text = "Docs", color = UiColor.Primary, variant = UiVariant.Soft)
        Badge(text = "Kotlin/JS", color = UiColor.Neutral, variant = UiVariant.Outline)
      }
      Div({ tw("max-w-3xl space-y-4") }) {
        H1({ tw("text-4xl font-black tracking-tight sm:text-5xl") }) {
          Text("Build with Compose daisyUI")
        }
        P({ tw("text-lg leading-8 text-base-content/75") }) {
          Text(
            "Install the library, configure Tailwind CSS 4 with daisyUI 5, " +
              "and start composing typed Kotlin components."
          )
        }
      }
      Div({ tw("flex flex-wrap gap-3") }) {
        A(attrs = {
          href("https://github.com/mahyarmlk/compose-daisy-ui")
          tw("btn btn-primary")
        }) {
          Text("GitHub")
        }
        A(attrs = {
          href("https://central.sonatype.com/artifact/io.github.mahyarmlk/compose-daisyui-js")
          tw("btn btn-outline")
        }) {
          Text("Maven Central")
        }
      }
    }
  }
}

@Composable
private fun DocsSidebar() {
  Nav({ tw("hidden lg:block") }) {
    Div({ tw("sticky top-24 rounded-box border border-base-300 bg-base-100 p-4") }) {
      Div({ tw("mb-3 text-xs font-bold uppercase text-base-content/60") }) {
        Text("On this page")
      }
      Ul({ tw("menu menu-sm rounded-box p-0") }) {
        SidebarLink("Quick start", "#quick-start")
        SidebarLink("Project setup", "#project-setup")
        SidebarLink("First component", "#first-component")
        SidebarLink("Theming", "#theming")
        SidebarLink("Component model", "#component-model")
      }
    }
  }
}

@Composable
private fun SidebarLink(label: String, target: String) {
  Li {
    A(attrs = { href(target) }) {
      Text(label)
    }
  }
}

@Composable
private fun QuickStartSection() {
  DocsSection(
    id = "quick-start",
    title = "Quick start",
    description = "Add the Kotlin/JS artifact, import Tailwind, and render a component."
  ) {
    Div({ tw("grid gap-4 lg:grid-cols-2") }) {
      StepCard("1", "Add the library", "Use the Compose daisyUI JS artifact in your Kotlin/JS app.")
      StepCard("2", "Enable CSS", "Import Tailwind CSS 4 and load the daisyUI plugin.")
      StepCard("3", "Render components", "Use typed composables like Button, Card, Badge, and Stats.")
      StepCard("4", "Choose a theme", "Set data-theme on your app root and switch it from Kotlin state.")
    }
  }
}

@Composable
private fun ProjectSetupSection() {
  DocsSection(
    id = "project-setup",
    title = "Project setup",
    description = "The demo uses npm dependencies through Gradle and a single CSS entrypoint."
  ) {
    DocsCode(
      "implementation(\"io.github.mahyarmlk:compose-daisyui-js:0.1.1\")",
      "implementation(npm(\"daisyui\", \"5.0.27\"))",
      "implementation(npm(\"tailwindcss\", \"4.1.18\"))",
      "implementation(npm(\"@tailwindcss/postcss\", \"4.1.18\"))"
    )
    DocsCode(
      "@import \"tailwindcss\";",
      "@plugin \"daisyui\" {",
      "  themes: light --default, dark --prefersdark, night;",
      "  logs: false;",
      "}"
    )
  }
}

@Composable
private fun FirstComponentSection() {
  DocsSection(
    id = "first-component",
    title = "First component",
    description = "High-level components map typed Kotlin enums onto daisyUI class tokens."
  ) {
    Div({ tw("grid gap-4 xl:grid-cols-[minmax(0,1fr)_320px]") }) {
      DocsCode(
        "Button(",
        "  text = \"Save changes\",",
        "  color = UiColor.Primary,",
        "  size = UiSize.Lg,",
        "  variant = UiVariant.Solid",
        ")"
      )
      Card(variant = CardVariant.Border, attrs = { tw("h-full") }) {
        Div({ tw("space-y-4") }) {
          H3({ tw("text-base font-bold") }) { Text("Rendered preview") }
          Button(
            text = "Save changes",
            color = UiColor.Primary,
            size = UiSize.Lg
          )
          P({ tw("text-sm leading-6 text-base-content/70") }) {
            Text("The wrapper adds the base btn class and only emits modifiers for typed options.")
          }
        }
      }
    }
  }
}

@Composable
private fun ThemingSection() {
  DocsSection(
    id = "theming",
    title = "Theming",
    description = "Themes are regular daisyUI themes. Compose state can update the data-theme attribute."
  ) {
    DocsCode(
      "var theme by remember { mutableStateOf(DaisyTheme.Night) }",
      "",
      "Div({",
      "  attr(\"data-theme\", theme.themeName)",
      "  tw(\"min-h-screen bg-base-100 text-base-content\")",
      "}) {",
      "  AppNavBar(currentTheme = theme, onThemeChange = { theme = it })",
      "}"
    )
    P({ tw("text-sm leading-6 text-base-content/75") }) {
      Text("Use semantic colors such as ")
      Span({ tw("font-mono text-primary") }) { Text("bg-primary") }
      Text(" and ")
      Span({ tw("font-mono text-primary") }) { Text("text-primary-content") }
      Text(" so components remain readable across themes.")
    }
  }
}

@Composable
private fun ComponentModelSection() {
  DocsSection(
    id = "component-model",
    title = "Component model",
    description = "The library has a thin core layer plus higher-level typed components."
  ) {
    Div({ tw("grid gap-4 md:grid-cols-2") }) {
      InfoCard(
        title = "Core tokens",
        body = "Daisy.Button.Btn and related tokens wrap raw daisyUI class names as DaisyToken values."
      )
      InfoCard(
        title = "Typed wrappers",
        body = "UiColor, UiSize, UiVariant, and component-specific models map to token helpers."
      )
      InfoCard(
        title = "Attrs escape hatch",
        body = "Every component accepts attrs so you can add HTML attributes and Tailwind utilities."
      )
      InfoCard(
        title = "Compose slots",
        body = "Components expose content slots for custom child content while keeping defaults concise."
      )
    }
    Div({ tw("pt-2") }) {
      Link(
        text = "Read the source on GitHub",
        href = "https://github.com/mahyarmlk/compose-daisy-ui",
        color = UiColor.Primary
      )
    }
  }
}

@Composable
private fun DocsSection(
  id: String,
  title: String,
  description: String,
  content: @Composable () -> Unit
) {
  Card(variant = CardVariant.Border, attrs = { attr("id", id); tw("scroll-mt-24") }) {
    Div({ tw("space-y-5") }) {
      Div({ tw("space-y-2") }) {
        H2({ tw("text-2xl font-extrabold tracking-tight") }) { Text(title) }
        P({ tw("max-w-3xl leading-7 text-base-content/75") }) { Text(description) }
      }
      content()
    }
  }
}

@Composable
private fun StepCard(index: String, title: String, body: String) {
  Div({ tw("rounded-box border border-base-300 bg-base-200 p-4") }) {
    Div({ tw("flex items-start gap-3") }) {
      Div({ tw("flex h-8 w-8 shrink-0 items-center justify-center rounded-field bg-primary text-sm font-bold text-primary-content") }) {
        Text(index)
      }
      Div({ tw("space-y-1") }) {
        H3({ tw("font-bold") }) { Text(title) }
        P({ tw("text-sm leading-6 text-base-content/75") }) { Text(body) }
      }
    }
  }
}

@Composable
private fun InfoCard(title: String, body: String) {
  Div({ tw("rounded-box border border-base-300 p-4") }) {
    H3({ tw("font-bold") }) { Text(title) }
    P({ tw("mt-2 text-sm leading-6 text-base-content/75") }) { Text(body) }
  }
}

@Composable
private fun DocsCode(vararg lines: String) {
  Div({
    tw(
      "mockup-code my-4 overflow-x-auto border border-base-content/10 " +
        "bg-neutral text-neutral-content"
    )
  }) {
    lines.forEachIndexed { index, line ->
      Div({
        attr("data-prefix", if (line.isEmpty()) " " else (index + 1).toString())
        tw("text-neutral-content")
      }) {
        Text(line.ifEmpty { " " })
      }
    }
  }
}
