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
 * A radio button with optional label.
 *
 * @see <a href="https://daisyui.com/components/radio/">daisyUI Radio docs</a>
 *
 * @param selected Whether this radio is selected.
 * @param onClick Callback when this radio is clicked.
 * @param label Optional text label next to the radio button.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param enabled Whether the radio is interactive.
 * @param attrs Additional input attributes.
 */
@Composable
public fun RadioButton(
  selected: Boolean,
  onClick: () -> Unit,
  label: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  ChoiceField(label = label) {
    Input(type = InputType.Radio, attrs = {
      daisy(
        Daisy.Form.Radio,
        color?.let { color("radio", it.toDaisyColor()) },
        size?.let { size("radio", it.toDaisySize()) })
      checked(selected)
      if (!enabled) disabled()
      onChange { if (it.value) onClick() }
      attrs?.invoke(this)
    })
  }
}
