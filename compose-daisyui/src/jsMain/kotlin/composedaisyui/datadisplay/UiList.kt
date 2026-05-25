package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLUListElement

/**
 * A vertical list container, typically used with [ListItem] children.
 *
 * @see <a href="https://daisyui.com/components/list/">daisyUI List docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content List content, usually [ListItem] composables.
 */
@Composable
public fun UiList(
  attrs: AttrBuilderContext<HTMLUListElement>? = null,
  content: ContentBuilder<HTMLUListElement>
) {
  Ul(attrs = {
    daisy(Daisy.Data.List, extra = "rounded-box bg-base-100 shadow-sm")
    attrs?.invoke(this)
  }, content = content)
}
