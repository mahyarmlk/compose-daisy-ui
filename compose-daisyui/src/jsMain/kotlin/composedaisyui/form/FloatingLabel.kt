package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLLabelElement

/**
 * A floating label that transitions above the input when focused or filled.
 *
 * @see <a href="https://daisyui.com/components/label/">daisyUI Label docs</a>
 *
 * @param label The floating label text.
 * @param attrs Additional HTML attributes.
 * @param content The input element wrapped by the floating label.
 */
@Composable
public fun FloatingLabel(
  label: String,
  attrs: AttrBuilderContext<HTMLLabelElement>? = null,
  content: ContentBuilder<HTMLLabelElement>
) {
  Label(attrs = {
    daisy(Daisy.Form.FloatingLabel)
    attrs?.invoke(this)
  }) {
    Span { Text(label) }
    content(this)
  }
}
