package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A container that rotates between child elements in a text-carousel style.
 *
 * @see <a href="https://daisyui.com/components/text-rotate/">daisyUI Text Rotate docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content The rotating text elements.
 */
@Composable
public fun TextRotate(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.TextRotate)
    attrs?.invoke(this)
  }, content = content)
}
