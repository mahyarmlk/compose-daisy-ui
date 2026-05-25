package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A fixed-position notification container for stacking toast messages.
 *
 * @see <a href="https://daisyui.com/components/toast/">daisyUI Toast docs</a>
 *
 * @param placement Where the toast stack appears on screen (defaults to bottom-end).
 * @param attrs Additional HTML attributes.
 * @param content Toast message components.
 */
@Composable
public fun Toast(
  placement: Set<ToastPlacement> = setOf(ToastPlacement.End, ToastPlacement.Bottom),
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Feedback.Toast, *placement.map { cls("toast-${it.name.lowercase()}") }.toTypedArray())
    attrs?.invoke(this)
  }, content = content)
}
