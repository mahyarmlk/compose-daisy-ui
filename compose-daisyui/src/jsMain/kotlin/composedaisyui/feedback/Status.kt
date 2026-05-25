package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

/**
 * A small colored dot indicator for showing online/offline or status.
 *
 * @see <a href="https://daisyui.com/components/status/">daisyUI Status docs</a>
 *
 * @param color Optional semantic color for the dot.
 * @param size Optional size preset.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Status(
  color: UiColor? = null,
  size: UiSize? = null,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null
) {
  Span(attrs = {
    daisy(Daisy.Feedback.Status, color?.let { color("status", it.toDaisyColor()) }, size?.let { size("status", it.toDaisySize()) })
    attrs?.invoke(this)
  })
}
