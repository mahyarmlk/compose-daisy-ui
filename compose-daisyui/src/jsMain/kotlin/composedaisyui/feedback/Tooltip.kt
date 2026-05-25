package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A hover tooltip that shows a text tip when the user hovers over the wrapped content.
 *
 * @see <a href="https://daisyui.com/components/tooltip/">daisyUI Tooltip docs</a>
 *
 * @param tip The tooltip text content.
 * @param placement Where the tooltip appears relative to the content.
 * @param open If true, forces the tooltip to stay open.
 * @param color Optional semantic color for the tooltip.
 * @param attrs Additional HTML attributes.
 * @param content The trigger element that activates the tooltip on hover.
 */
@Composable
public fun Tooltip(
  tip: String,
  placement: TooltipPlacement? = null,
  open: Boolean = false,
  color: UiColor? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(
      Daisy.Feedback.Tooltip,
      placement?.let { cls("tooltip-${it.name.lowercase()}") },
      if (open) Daisy.Feedback.TooltipOpen else null,
      color?.let { color("tooltip", it.toDaisyColor()) }
    )
    attr("data-tip", tip)
    attrs?.invoke(this)
  }, content = content)
}
