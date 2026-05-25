package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.Field
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Input

/**
 * A file picker input with optional label.
 *
 * @see <a href="https://daisyui.com/components/file-input/">daisyUI File Input docs</a>
 *
 * @param label Optional field label.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param enabled Whether the input is interactive.
 * @param attrs Additional input attributes.
 */
@Composable
public fun FileInputField(
  label: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  attrs: (InputAttrsScope<String>.() -> Unit)? = null
) {
  Field(label = label) {
    Input(type = InputType.File, attrs = {
      daisy(Daisy.Form.FileInput, color?.let { color("file-input", it.toDaisyColor()) }, size?.let { size("file-input", it.toDaisySize()) }, extra = "w-full")
      if (!enabled) disabled()
      attrs?.invoke(this)
    })
  }
}
