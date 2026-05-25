package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A hover gallery where the first image is visible and the others appear on hover.
 * Useful for product image galleries.
 *
 * @see <a href="https://daisyui.com/components/hover-gallery/">daisyUI Hover Gallery docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Gallery images (up to 10).
 */
@Composable
public fun HoverGallery(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.HoverGallery)
    attrs?.invoke(this)
  }, content = content)
}
