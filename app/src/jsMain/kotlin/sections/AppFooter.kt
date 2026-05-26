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
        A(attrs = { href("#components"); tw("link link-hover text-base-content/75") }) { Text("Components") }
        A(attrs = { href("#themes"); tw("link link-hover text-base-content/75") }) { Text("Themes") }
        A(attrs = { href("https://github.com/mahyarmlk/compose-daisy-ui#readme"); tw("link link-hover text-base-content/75") }) { Text("Documentation") }
      }
      Nav({ tw("flex flex-col gap-2") }) {
        Span({ tw("footer-title opacity-100") }) { Text("Resources") }
        A(attrs = { href("https://github.com/mahyarmlk/compose-daisy-ui"); tw("link link-hover text-base-content/75") }) { Text("GitHub") }
        A(attrs = { href("https://github.com/mahyarmlk/compose-daisy-ui/blob/main/CHANGELOG.md"); tw("link link-hover text-base-content/75") }) { Text("Changelog") }
        A(attrs = { href("https://central.sonatype.com/artifact/io.github.mahyarmlk/compose-daisyui-js"); tw("link link-hover text-base-content/75") }) { Text("Maven Central") }
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
      P({ tw("text-sm text-base-content/70") }) {
        Text("Built with Compose daisyUI — Kotlin/JS + daisyUI 5")
      }
    }
  }
}
