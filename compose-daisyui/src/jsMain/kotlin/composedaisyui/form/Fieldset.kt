package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element

/**
 * A fieldset container for grouping related form controls with an optional legend.
 *
 * @see <a href="https://daisyui.com/components/fieldset/">daisyUI Fieldset docs</a>
 *
 * @param legend Optional legend/caption for the fieldset group.
 * @param attrs Additional HTML attributes.
 * @param content Form controls wrapped by the fieldset.
 */
@Composable
public fun Fieldset(
  legend: String? = null,
  attrs: AttrBuilderContext<Element>? = null,
  content: ContentBuilder<Element>
) {
  DaisyGeneric("fieldset", Daisy.Form.Fieldset, attrs = attrs) {
    legend?.let { DaisyGeneric("legend", Daisy.Form.FieldsetLegend) { Text(it) } }
    content(this)
  }
}
