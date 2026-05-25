package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.Element

/**
 * A collapsible section that toggles visibility on click. Alias for [Accordion].
 *
 * @see <a href="https://daisyui.com/components/collapse/">daisyUI Collapse docs</a>
 *
 * @param title The visible toggle title.
 * @param open Whether this collapse is initially open.
 * @param arrow If true, shows an arrow indicator.
 * @param plus If true, shows a plus/minus indicator.
 * @param attrs Additional HTML attributes.
 * @param content Content revealed when expanded.
 */
@Composable
public fun Collapse(
  title: String,
  open: Boolean = false,
  arrow: Boolean = true,
  plus: Boolean = false,
  attrs: AttrBuilderContext<Element>? = null,
  content: ContentBuilder<Element>
) {
  Accordion(title = title, open = open, arrow = arrow, plus = plus, attrs = attrs, content = content)
}
