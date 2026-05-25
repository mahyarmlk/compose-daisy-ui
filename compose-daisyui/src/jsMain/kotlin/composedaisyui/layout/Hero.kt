package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A prominent hero section with optional overlay and centered content.
 *
 * @see <a href="https://daisyui.com/components/hero/">daisyUI Hero docs</a>
 *
 * @param overlay Optional overlay composable (e.g., background dimming).
 * @param attrs Additional HTML attributes.
 * @param content The hero body content.
 */
@Composable
public fun Hero(
  overlay: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Layout.Hero)
    attrs?.invoke(this)
  }) {
    overlay?.let { Div({ daisy(Daisy.Layout.HeroOverlay) }) { it() } }
    Div({ daisy(Daisy.Layout.HeroContent) }) { content(this) }
  }
}
