package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * A radial (circular) progress indicator showing a value as a percentage arc.
 *
 * @see <a href="https://daisyui.com/components/radial-progress/">daisyUI Radial Progress docs</a>
 *
 * @param value The progress value (0-100).
 * @param label The label text shown in the center.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun RadialProgress(
  value: Number,
  label: String = "$value%",
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Feedback.RadialProgress)
    style { property("--value", value.toString()) }
    attr("role", "progressbar")
    attrs?.invoke(this)
  }) { Text(label) }
}
