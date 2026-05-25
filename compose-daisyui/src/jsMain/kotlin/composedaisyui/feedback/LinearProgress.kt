package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Progress
import org.w3c.dom.HTMLProgressElement

/**
 * A linear progress bar indicating completion or indeterminate progress.
 *
 * @see <a href="https://daisyui.com/components/progress/">daisyUI Progress docs</a>
 *
 * @param value The current progress value. If null, shows an indeterminate animation.
 * @param max The maximum progress value.
 * @param color Optional semantic color.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun LinearProgress(
  value: Number? = null,
  max: Number = 100,
  color: UiColor? = null,
  attrs: AttrBuilderContext<HTMLProgressElement>? = null
) {
  Progress(attrs = {
    daisy(Daisy.Feedback.Progress, color?.let { color("progress", it.toDaisyColor()) })
    value?.let { attr("value", it.toString()) }
    attr("max", max.toString())
    attrs?.invoke(this)
  })
}

/**
 * A linear progress bar. Alias for [LinearProgress].
 *
 * @see [LinearProgress]
 */
@Composable
public fun Progress(
  value: Number? = null,
  max: Number = 100,
  color: UiColor? = null,
  attrs: AttrBuilderContext<HTMLProgressElement>? = null
) {
  LinearProgress(value = value, max = max, color = color, attrs = attrs)
}
