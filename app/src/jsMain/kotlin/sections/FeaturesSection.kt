package sections

import androidx.compose.runtime.Composable
import composedaisyui.CardVariant
import composedaisyui.UiColor
import composedaisyui.UiSize
import composedaisyui.UiVariant
import composedaisyui.datadisplay.Badge
import composedaisyui.datadisplay.Card
import composedaisyui.tw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun FeaturesSection() {
  Div({ tw("py-24 px-4 sm:px-6 lg:px-8 max-w-7xl mx-auto") }) {
    Div({ tw("text-center mb-16") }) {
      Div({ tw("mb-4") }) {
        Span({ tw("badge badge-ghost badge-sm") }) { Text("Why Compose daisyUI?") }
      }
      H2({ tw("text-4xl font-extrabold tracking-tight") }) {
        Text("Everything you need")
      }
      P({ tw("mt-4 text-lg text-base-content/50 max-w-2xl mx-auto leading-relaxed") }) {
        Text("Build modern, themeable web UIs with Kotlin — no JavaScript required.")
      }
    }

    Div({ tw("grid gap-8 sm:grid-cols-2 lg:grid-cols-3") }) {
      FeatureCard(
        icon = "🎨",
        title = "35+ Themes",
        description = "Switch between light and dark themes instantly. Every component adapts automatically with semantic color tokens.",
        badges = listOf("daisyUI 5", "Theming")
      )
      FeatureCard(
        icon = "🧩",
        title = "Compose-First API",
        description = "Idiomatic Kotlin composables with typed parameters, state hoisting, and flexible slot-based content.",
        badges = listOf("Compose HTML", "Type-safe")
      )
      FeatureCard(
        icon = "⚡",
        title = "Production Ready",
        description = "Semantic color system, responsive utilities, and accessible components following WAI-ARIA best practices.",
        badges = listOf("Accessible", "Performant")
      )
      FeatureCard(
        icon = "🛠",
        title = "Tailwind Powered",
        description = "Built on Tailwind CSS 4 and daisyUI 5. Leverage thousands of utility classes alongside component tokens.",
        badges = listOf("Tailwind 4", "Utility-first")
      )
      FeatureCard(
        icon = "📦",
        title = "Tree-Shakeable",
        description = "Kotlin/JS IR compiler eliminates dead code automatically. Only ship the components you actually use.",
        badges = listOf("Kotlin/JS", "Optimized")
      )
      FeatureCard(
        icon = "🔌",
        title = "Full Control",
        description = "Every component accepts an attrs block for direct HTML attribute access. Never feel boxed in by the abstraction.",
        badges = listOf("Flexible", "Extensible")
      )
    }
  }
}

@Composable
private fun FeatureCard(
  icon: String,
  title: String,
  description: String,
  badges: List<String>
) {
  Card(
    variant = CardVariant.Border,
    attrs = { tw("group hover:shadow-md transition-shadow duration-300 h-full") }
  ) {
    Div({ tw("flex flex-col gap-4") }) {
      Div({ tw("flex items-start gap-4") }) {
        Div({ tw("w-12 h-12 rounded-xl bg-primary/10 flex items-center justify-center text-2xl group-hover:scale-110 transition-transform duration-300 shrink-0") }) {
          Text(icon)
        }
        Div({ tw("flex-1 min-w-0") }) {
          H3({ tw("text-lg font-semibold mb-1.5") }) { Text(title) }
          P({ tw("text-sm text-base-content/60 leading-relaxed") }) {
            Text(description)
          }
        }
      }
      Div({ tw("flex flex-wrap gap-2") }) {
        badges.forEach { badge ->
          Badge(
            text = badge,
            variant = UiVariant.Outline,
            size = UiSize.Sm,
            color = UiColor.Primary
          )
        }
      }
    }
  }
}
