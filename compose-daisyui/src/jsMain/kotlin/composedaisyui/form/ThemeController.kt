package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Input

/**
 * A theme controller toggle that sets a data-theme value via a checkbox.
 *
 * @see <a href="https://daisyui.com/components/theme-controller/">daisyUI Theme Controller docs</a>
 *
 * @param value The theme name to apply when checked.
 * @param checked Whether the theme is active.
 * @param attrs Additional input attributes.
 */
@Composable
public fun ThemeController(
  value: String,
  checked: Boolean,
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  Input(type = InputType.Checkbox, attrs = {
    daisy(Daisy.Form.ThemeController)
    attr("value", value)
    checked(checked)
    attrs?.invoke(this)
  })
}
