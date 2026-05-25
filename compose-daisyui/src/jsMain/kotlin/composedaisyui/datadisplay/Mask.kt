package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.maskToken
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * Crops content to a specific shape (circle, star, hexagon, etc.).
 *
 * @see <a href="https://daisyui.com/components/mask/">daisyUI Mask docs</a>
 *
 * @param shape The geometric mask shape to apply.
 * @param attrs Additional HTML attributes.
 * @param content The content to be masked.
 */
@Composable
public fun Mask(
  shape: MaskShape,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.Mask, shape.maskToken())
    attrs?.invoke(this)
  }, content = content)
}
