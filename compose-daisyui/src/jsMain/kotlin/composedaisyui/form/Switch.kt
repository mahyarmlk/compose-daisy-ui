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
 * A toggle switch with optional label.
 *
 * @see <a href="https://daisyui.com/components/toggle/">daisyUI Toggle docs</a>
 *
 * @param checked Whether the switch is on.
 * @param onCheckedChange Callback when the state changes.
 * @param label Optional text label displayed next to the switch.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param enabled Whether the switch is interactive.
 * @param attrs Additional input attributes.
 */
@Composable
public fun Switch(
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
        Daisy.Form.Toggle,
        color?.let { color("toggle", it.toDaisyColor()) },
        size?.let { size("toggle", it.toDaisySize()) })
      checked(checked)
      if (!enabled) disabled()
      onChange { onCheckedChange(it.value) }
      attrs?.invoke(this)
    })
  }
}
