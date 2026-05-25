package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.Input

/**
 * A range slider for selecting a numeric value within a range.
 *
 * @see <a href="https://daisyui.com/components/range/">daisyUI Range docs</a>
 *
 * @param value The current slider value.
 * @param onValueChange Callback when the value changes.
 * @param min The minimum slider value.
 * @param max The maximum slider value.
 * @param step The increment step.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param enabled Whether the slider is interactive.
 * @param attrs Additional input attributes.
 */
@Composable
public fun Slider(
  value: Number,
  onValueChange: (Number?) -> Unit,
  min: Number = 0,
  max: Number = 100,
  step: Number = 1,
  color: UiColor? = null,
  size: UiSize? = null,
  enabled: Boolean = true,
  attrs: (InputAttrsScope<Number?>.() -> Unit)? = null
) {
  Input(type = InputType.Range, attrs = {
    daisy(
      Daisy.Form.Range,
      color?.let { color("range", it.toDaisyColor()) },
      size?.let { size("range", it.toDaisySize()) })
    value(value)
    attr("min", min.toString())
    attr("max", max.toString())
    attr("step", step.toString())
    if (!enabled) disabled()
    onInput { onValueChange(it.value) }
    attrs?.invoke(this)
  })
}
