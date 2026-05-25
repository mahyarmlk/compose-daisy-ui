package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A stacking container for layering elements on top of each other.
 *
 * @see <a href="https://daisyui.com/components/stack/">daisyUI Stack docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Stacked child elements.
 */
@Composable
public fun Stack(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Layout.Stack)
    attrs?.invoke(this)
  }, content = content)
}
