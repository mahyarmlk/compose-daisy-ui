package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Input

/**
 * A reset radio input for clearing the [Filter] selection.
 *
 * @see <a href="https://daisyui.com/components/filter/">daisyUI Filter docs</a>
 *
 * @param text The accessible label for the reset button.
 * @param attrs Additional input attributes.
 */
@Composable
public fun FilterReset(
  text: String = "Reset",
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  Input(type = InputType.Radio, attrs = {
    daisy(Daisy.Form.FilterReset, Daisy.Button.Btn, Daisy.Button.Sm)
    attr("aria-label", text)
    attrs?.invoke(this)
  })
}
