package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.actions.Button
import composedaisyui.layout.Join
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A pagination control built with joined buttons.
 *
 * @see <a href="https://daisyui.com/components/join/">daisyUI Pagination (Join) docs</a>
 *
 * @param items The pagination page items.
 * @param onItemClick Callback with the clicked page index.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Pagination(
  items: List<PaginationItem>,
  onItemClick: (Int) -> Unit,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Join(attrs = attrs) {
    items.forEachIndexed { index, item ->
      Button(
        text = item.label,
        variant = if (item.active) UiVariant.Solid else UiVariant.Outline,
        enabled = !item.disabled,
        attrs = { daisy(Daisy.Layout.JoinItem); onClick { onItemClick(index) } }
      )
    }
  }
}
