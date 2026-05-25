package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.ChoiceField
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Input

/**
 * A checkbox input with optional label.
 *
 * @see <a href="https://daisyui.com/components/checkbox/">daisyUI Checkbox docs</a>
 *
 * @param checked Whether the checkbox is checked.
 * @param onCheckedChange Callback when the checked state changes.
 * @param label Optional text label displayed next to the checkbox.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param enabled Whether the checkbox is interactive.
 * @param attrs Additional input attributes.
 */
@Composable
public fun Checkbox(
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
  label: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  ChoiceField(label = label) {
    Input(type = InputType.Checkbox, attrs = {
      daisy(
        Daisy.Form.Checkbox,
        color?.let { color("checkbox", it.toDaisyColor()) },
        size?.let { size("checkbox", it.toDaisySize()) })
      checked(checked)
      if (!enabled) disabled()
      onChange { onCheckedChange(it.value) }
      attrs?.invoke(this)
    })
  }
}
