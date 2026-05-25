package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.Daisy
import composedaisyui.DaisyGeneric
import composedaisyui.daisy
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element

/**
 * A collapsible details/summary section. Multiple Accordions with the same radio name
 * behave as an exclusive group (only one open at a time).
 *
 * @see <a href="https://daisyui.com/components/accordion/">daisyUI Accordion docs</a>
 *
 * @param title The visible toggle title.
 * @param open Whether this accordion is initially open.
 * @param arrow If true, shows an arrow indicator.
 * @param plus If true, shows a plus/minus indicator.
 * @param attrs Additional HTML attributes.
 * @param content Content revealed when expanded.
 */
@Composable
public fun Accordion(
  title: String,
  open: Boolean = false,
  arrow: Boolean = true,
  plus: Boolean = false,
  attrs: AttrBuilderContext<Element>? = null,
  content: ContentBuilder<Element>
) {
  DaisyGeneric(
    "details",
    Daisy.Accordion.Collapse,
    if (arrow) Daisy.Accordion.Arrow else null,
    if (plus) Daisy.Accordion.Plus else null,
    if (open) Daisy.Accordion.Open else null,
    attrs = {
      if (open) attr("open", "")
      attrs?.invoke(this)
    }
  ) {
    DaisyGeneric("summary", Daisy.Accordion.Title) { Text(title) }
    DaisyGeneric("div", Daisy.Accordion.Content, content = content)
  }
}
