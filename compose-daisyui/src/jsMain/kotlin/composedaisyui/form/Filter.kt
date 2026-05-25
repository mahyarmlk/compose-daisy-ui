package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A filter bar that groups radio buttons. Selecting one hides others and shows a reset.
 *
 * @see <a href="https://daisyui.com/components/filter/">daisyUI Filter docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Filter radio inputs (typically [FilterReset] + filter options).
 */
@Composable
public fun Filter(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Form.Filter)
    attrs?.invoke(this)
  }, content = content)
}
