package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * Displays validation hint text below a form field.
 *
 * @see <a href="https://daisyui.com/components/validator/">daisyUI Validator docs</a>
 *
 * @param text The validation hint or error message.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun ValidatorHint(
  text: String,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Form.ValidatorHint)
    attrs?.invoke(this)
  }) { Text(text) }
}
