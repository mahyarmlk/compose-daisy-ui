package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * A horizontal or vertical divider line, optionally with centered text.
 *
 * @see <a href="https://daisyui.com/components/divider/">daisyUI Divider docs</a>
 *
 * @param text Optional text displayed in the divider gap.
 * @param orientation Horizontal or vertical orientation.
 * @param placement For horizontal dividers, where the text appears (start/end).
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Divider(
  text: String? = null,
  orientation: UiOrientation? = null,
  placement: DividerPlacement? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(
      Daisy.Layout.Divider,
      orientation?.let { direction("divider", it.toDaisyDirection()) },
      placement?.let { cls("divider-${it.name.lowercase()}") }
    )
    attrs?.invoke(this)
  }) {
    text?.let { Text(it) }
  }
}
