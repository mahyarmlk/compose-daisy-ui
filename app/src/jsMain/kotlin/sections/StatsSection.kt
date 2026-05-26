package sections

import androidx.compose.runtime.Composable
import composedaisyui.StatItem
import composedaisyui.UiOrientation
import composedaisyui.datadisplay.Stats
import composedaisyui.tw
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun StatsSection() {
  Div({ tw("bg-base-200 py-20 sm:py-24") }) {
    Div({ tw("max-w-7xl mx-auto px-4 sm:px-6 lg:px-8") }) {
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

      Stats(
        items = listOf(
          StatItem("Components", "80+", "From buttons to modals"),
          StatItem("Themes", "35", "Built-in and customizable"),
          StatItem("Semantic colors", "8", "Auto-adapt to theme"),
          StatItem("Size variants", "5", "XS through XL")
        ),
        orientation = UiOrientation.Vertical,
        attrs = {
          tw(
            "w-full lg:stats-horizontal " +
              "bg-base-100 border border-base-300 shadow-sm"
          )
        }
      )
    }
  }
}
