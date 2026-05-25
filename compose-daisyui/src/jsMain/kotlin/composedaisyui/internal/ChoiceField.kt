package composedaisyui.internal

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * Inline choice control wrapper (checkbox, radio, switch) with label.
 */
@Composable
internal fun ChoiceField(
  label: String?,
  content: @Composable () -> Unit
) {
  Label(attrs = {
    daisy(
      Daisy.Form.Label,
      extra = "inline-flex cursor-pointer items-center gap-3"
    )
  }) {
    content()
    label?.let { Span { Text(it) } }
  }
}
