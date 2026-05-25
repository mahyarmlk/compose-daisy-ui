package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * A standalone label text element.
 *
 * @see <a href="https://daisyui.com/components/label/">daisyUI Label docs</a>
 *
 * @param text The label content.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun LabelText(
  text: String,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null
) {
  Span(attrs = {
    daisy(Daisy.Form.Label)
    attrs?.invoke(this)
  }) { Text(text) }
}
