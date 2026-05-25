package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.Field
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.selected
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSelectElement

/**
 * A styled select dropdown with label and helper text.
 *
 * @see <a href="https://daisyui.com/components/select/">daisyUI Select docs</a>
 *
 * @param value The currently selected option value.
 * @param options The list of available options.
 * @param onValueChange Callback when selection changes.
 * @param label Optional field label.
 * @param helperText Optional helper/error text below the field.
 * @param color Optional semantic color for border/focus.
 * @param size Optional size preset.
 * @param enabled Whether the field is interactive.
 * @param attrs Additional select attributes.
 */
@Composable
public fun SelectField(
  value: String,
  options: List<SelectOption>,
  onValueChange: (String) -> Unit,
  label: String? = null,
  helperText: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  attrs: AttrBuilderContext<HTMLSelectElement>? = null
) {
  Field(label = label, helperText = helperText) { fieldId ->
    Select(attrs = {
      daisy(
        Daisy.Form.Select,
        color?.let { color("select", it.toDaisyColor()) },
        size?.let { size("select", it.toDaisySize()) },
        extra = "w-full"
      )
      fieldId?.let { attr("id", it) }
      if (!enabled) disabled()
      onChange { event -> event.value?.let(onValueChange) }
      attrs?.invoke(this)
    }) {
      options.forEach { option ->
        Option(value = option.value, attrs = {
          if (option.value == value) selected()
          if (option.disabled) disabled()
        }) { Text(option.label) }
      }
    }
  }
}
