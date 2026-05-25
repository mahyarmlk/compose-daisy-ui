package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

/**
 * An animated countdown that transitions between numeric values (0-999).
 *
 * @see <a href="https://daisyui.com/components/countdown/">daisyUI Countdown docs</a>
 *
 * @param value The current numeric value to display.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Countdown(
  value: Number,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null
) {
  Span(attrs = {
    daisy(Daisy.Display.Countdown)
    style { property("--value", value.toString()) }
    attrs?.invoke(this)
  })
}
