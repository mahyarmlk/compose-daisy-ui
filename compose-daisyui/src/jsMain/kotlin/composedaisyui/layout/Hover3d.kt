package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * Adds a 3D tilt effect on hover. The first child is the content and the next 8
 * children must be empty `<div>` elements for hover detection zones.
 *
 * @see <a href="https://daisyui.com/components/hover-3d/">daisyUI Hover 3D docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Must contain exactly 9 children: 1 content element + 8 empty divs.
 */
@Composable
public fun Hover3d(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.Hover3d)
    attrs?.invoke(this)
  }, content = content)
}
