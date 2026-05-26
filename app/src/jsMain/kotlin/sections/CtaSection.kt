package sections

import androidx.compose.runtime.Composable
import composedaisyui.UiColor
import composedaisyui.UiSize
import composedaisyui.UiVariant
import composedaisyui.actions.Button
import composedaisyui.tw
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun CtaSection() {
  Div({ tw("py-24 px-4 sm:px-6 lg:px-8 max-w-7xl mx-auto") }) {
    Div({ tw("rounded-box bg-primary text-primary-content p-10 sm:p-14 lg:p-16 text-center shadow-xl") }) {
      Div({ tw("relative z-10 flex flex-col items-center gap-6") }) {
        Div({ tw("mb-2") }) {
          Span({ tw("badge badge-outline border-primary-content/30 text-primary-content/80 text-xs font-semibold") }) {
            Text("Open Source")
          }
        }
        H3({ tw("text-3xl sm:text-4xl lg:text-5xl font-extrabold tracking-tight") }) {
          Text("Ready to build something great?")
        }
        P({ tw("text-lg text-primary-content/85 max-w-2xl leading-relaxed") }) {
          Text("Add Compose daisyUI to your Kotlin/JS project and start building beautiful, themeable UIs in minutes.")
        }
        Div({ tw("flex gap-4 flex-wrap justify-center pt-4") }) {
          Button(
            text = "Get Started",
            size = UiSize.Lg,
            attrs = { tw("bg-primary-content text-primary border-primary-content hover:bg-primary-content/90") }
          )
          Button(
            text = "View on GitHub",
            variant = UiVariant.Outline,
            size = UiSize.Lg,
            attrs = { tw("border-primary-content/30 hover:border-primary-content") }
          )
        }
        Div({ tw("flex gap-6 text-sm text-primary-content/80 pt-4") }) {
          A("/compose-daisy-ui/LICENSE", { tw("link link-hover") }) {
            Text("Apache-2.0 License")
          }
          Span { Text("·") }
          A("https://central.sonatype.com/artifact/io.github.mahyarmlk/compose-daisyui-js", { tw("link link-hover") }) {
            Text("Maven Central")
          }
          Span { Text("·") }
          A("https://github.com/mahyarmlk/compose-daisy-ui", { tw("link link-hover") }) {
            Text("GitHub")
          }
        }
      }
    }
  }
}
