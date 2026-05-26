package sections

import androidx.compose.runtime.Composable
import composedaisyui.UiColor
import composedaisyui.UiSize
import composedaisyui.UiVariant
import composedaisyui.datadisplay.Badge
import composedaisyui.layout.Divider
import composedaisyui.layout.Footer
import composedaisyui.tw
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun AppFooter() {
  Footer(
    attrs = { tw("bg-base-200 text-base-content border-t border-base-300") }
  ) {
    Div({ tw("max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-10 flex flex-col sm:flex-row gap-10 sm:gap-20") }) {
      Nav({ tw("flex flex-col gap-2") }) {
        Span({ tw("footer-title opacity-100") }) { Text("Product") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Components") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Themes") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Documentation") }
      }
      Nav({ tw("flex flex-col gap-2") }) {
        Span({ tw("footer-title opacity-100") }) { Text("Resources") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("GitHub") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Changelog") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Examples") }
      }
      Nav({ tw("flex flex-col gap-2") }) {
        Span({ tw("footer-title opacity-100") }) { Text("Community") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Discord") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Twitter") }
        A(attrs = { href("#"); tw("link link-hover text-base-content/60") }) { Text("Blog") }
      }
    }

    Divider(attrs = { tw("max-w-7xl mx-auto px-4 sm:px-6 lg:px-8") })

    Div({ tw("flex flex-col sm:flex-row items-center justify-between gap-4 max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-6") }) {
      Div({ tw("flex items-center gap-3") }) {
        Span({ tw("text-lg font-bold text-primary") }) { Text("Compose daisyUI") }
        Badge(
          text = "v0.1.1",
          variant = UiVariant.Soft,
          size = UiSize.Sm,
          color = UiColor.Primary
        )
      }
      P({ tw("text-sm text-base-content/40") }) {
        Text("Built with Compose daisyUI — Kotlin/JS + daisyUI 5")
      }
    }
  }
}
