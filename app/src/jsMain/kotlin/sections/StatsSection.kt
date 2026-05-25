package sections

import androidx.compose.runtime.Composable
import composedaisyui.StatItem
import composedaisyui.datadisplay.Stats
import composedaisyui.tw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun StatsSection() {
  Div({ tw("py-24 px-4 sm:px-6 lg:px-8 bg-base-200 rounded-3xl max-w-7xl mx-auto my-8") }) {
    Div({ tw("text-center mb-16") }) {
      Div({ tw("mb-4") }) {
        Span({ tw("badge badge-ghost badge-sm") }) { Text("By the Numbers") }
      }
      H2({ tw("text-4xl font-extrabold tracking-tight") }) {
        Text("Trusted by developers")
      }
      P({ tw("mt-4 text-lg text-base-content/50 max-w-xl mx-auto leading-relaxed") }) {
        Text("Compose daisyUI brings a comprehensive set of UI primitives to the Kotlin ecosystem.")
      }
    }

    Div({ tw("grid gap-6 sm:grid-cols-2 lg:grid-cols-4 px-4") }) {
      StatCard("80+", "Components", "From buttons to modals")
      StatCard("35", "Themes", "Built-in & customizable")
      StatCard("8", "Semantic Colors", "Auto-adapt to theme")
      StatCard("5", "Size Variants", "XS through XL")
    }
  }
}

@Composable
private fun StatCard(value: String, title: String, desc: String) {
  Div({ tw("flex flex-col items-center text-center p-8 rounded-2xl bg-base-100 shadow-sm border border-base-300 hover:shadow-md transition-shadow duration-300") }) {
    Div({ tw("text-4xl font-extrabold text-primary mb-3 tracking-tight") }) {
      Text(value)
    }
    Div({ tw("text-sm font-semibold text-base-content mb-1") }) {
      Text(title)
    }
    Div({ tw("text-xs text-base-content/40") }) {
      Text(desc)
    }
  }
}
