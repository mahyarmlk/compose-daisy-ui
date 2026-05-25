package composedaisyui.internal

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.forId
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLLabelElement

/**
 * Form field wrapper that provides label, input slot, and helper text.
 */
@Composable
internal fun Field(
  label: String? = null,
  helperText: String? = null,
  attrs: AttrBuilderContext<HTMLLabelElement>? = null,
  content: @Composable (fieldId: String?) -> Unit
) {
  val fieldId = label?.stableId("field")
  Label(attrs = {
    daisy(Daisy.Form.Label, extra = "grid gap-1.5")
    fieldId?.let { forId(it) }
    attrs?.invoke(this)
  }) {
    label?.let { Span({ daisy(extra = "text-sm font-medium") }) { Text(it) } }
    content(fieldId)
    helperText?.let { Span({ daisy(extra = "text-xs text-base-content/60") }) { Text(it) } }
  }
}

/**
 * Generates a stable HTML id from a string for use in label/input pairing.
 */
internal fun String.stableId(prefix: String): String =
  "$prefix-" + lowercase()
    .replace(Regex("[^a-z0-9]+"), "-")
    .trim('-')
    .ifBlank { "input" }
