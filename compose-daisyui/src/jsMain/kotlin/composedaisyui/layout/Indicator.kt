package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLDivElement

/**
 * Places an indicator element (e.g., badge, dot) on the corner of another element.
 *
 * @see <a href="https://daisyui.com/components/indicator/">daisyUI Indicator docs</a>
 *
 * @param item The indicator item to position (e.g., a badge).
 * @param attrs Additional HTML attributes.
 * @param content The main content element.
 */
@Composable
public fun Indicator(
  item: @Composable () -> Unit,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Layout.Indicator)
    attrs?.invoke(this)
  }) {
    Span({ daisy(Daisy.Layout.IndicatorItem) }) { item() }
    content(this)
  }
}
