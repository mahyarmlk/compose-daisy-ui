package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.Field
import org.jetbrains.compose.web.attributes.builders.TextAreaAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.dom.TextArea

/**
 * A styled multi-line text area with label and helper text.
 *
 * @see <a href="https://daisyui.com/components/textarea/">daisyUI Textarea docs</a>
 *
 * @param value The current text value.
 * @param onValueChange Callback when the text changes.
 * @param label Optional field label.
 * @param placeholder Optional placeholder text.
 * @param helperText Optional helper/error text below the field.
 * @param color Optional semantic color for border/focus.
 * @param size Optional size preset.
 * @param enabled Whether the field is interactive.
 * @param attrs Additional textarea attributes.
 */
@Composable
public fun TextAreaField(
  value: String,
  onValueChange: (String) -> Unit,
  label: String? = null,
  placeholder: String? = null,
  helperText: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  attrs: (TextAreaAttrsScope.() -> Unit)? = null
) {
  Field(label = label, helperText = helperText) { fieldId ->
    TextArea(value = value, attrs = {
      daisy(
        Daisy.Form.Textarea,
        color?.let { color("textarea", it.toDaisyColor()) },
        size?.let { size("textarea", it.toDaisySize()) },
        extra = "w-full"
      )
      fieldId?.let { attr("id", it) }
      placeholder?.let { placeholder(it) }
      if (!enabled) disabled()
      onInput { onValueChange(it.value) }
      attrs?.invoke(this)
    })
  }
}
