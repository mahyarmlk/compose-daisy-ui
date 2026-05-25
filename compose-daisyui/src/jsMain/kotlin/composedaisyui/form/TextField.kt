package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.Field
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Input

/**
 * A styled single-line text input field with label and helper text.
 *
 * @see <a href="https://daisyui.com/components/input/">daisyUI Input docs</a>
 *
 * @param value The current text value.
 * @param onValueChange Callback when the text changes.
 * @param label Optional field label.
 * @param placeholder Optional placeholder text.
 * @param helperText Optional helper/error text below the field.
 * @param color Optional semantic color for border/focus.
 * @param size Optional size preset.
 * @param enabled Whether the field is interactive.
 * @param type The HTML input type (text, email, password, etc.).
 * @param attrs Additional input attributes.
 */
@Composable
public fun TextField(
  value: String,
  onValueChange: (String) -> Unit,
  label: String? = null,
  placeholder: String? = null,
  helperText: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  type: InputType<String> = InputType.Text,
  attrs: (InputAttrsScope<String>.() -> Unit)? = null
) {
  Field(label = label, helperText = helperText) { fieldId ->
    Input(type = type, attrs = {
      daisy(
        Daisy.Form.Input,
        color?.let { color("input", it.toDaisyColor()) },
        size?.let { size("input", it.toDaisySize()) },
        extra = "w-full"
      )
      value(value)
      fieldId?.let { attr("id", it) }
      placeholder?.let { placeholder(it) }
      if (!enabled) disabled()
      onInput { onValueChange(it.value) }
      attrs?.invoke(this)
    })
  }
}
