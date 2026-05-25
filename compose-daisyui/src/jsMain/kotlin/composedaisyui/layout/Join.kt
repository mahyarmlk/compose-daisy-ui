package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * Joins multiple child elements together, merging their borders.
 * Ideal for button groups, input groups, and pagination.
 *
 * @see <a href="https://daisyui.com/components/join/">daisyUI Join docs</a>
 *
 * @param orientation Layout direction (horizontal or vertical).
 * @param attrs Additional HTML attributes.
 * @param content Child elements to join (use [JoinItem] for individual items).
 */
@Composable
public fun Join(
  orientation: UiOrientation? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Layout.Join, orientation?.let { direction("join", it.toDaisyDirection()) })
    attrs?.invoke(this)
  }, content = content)
}

/**
 * A single item within a [Join] group.
 *
 * @see [Join]
 *
 * @param attrs Additional HTML attributes.
 * @param content Item content.
 */
@Composable
public fun JoinItem(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Layout.JoinItem)
    attrs?.invoke(this)
  }, content = content)
}
