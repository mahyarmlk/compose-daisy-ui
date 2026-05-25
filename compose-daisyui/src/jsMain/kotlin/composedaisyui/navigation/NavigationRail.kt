package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLUListElement

/**
 * A vertical navigation rail with selectable items.
 *
 * @see <a href="https://daisyui.com/components/menu/">daisyUI Menu docs</a>
 *
 * @param items Navigation item label strings.
 * @param selectedIndex The zero-based index of the active item.
 * @param onSelectedIndexChange Callback when an item is clicked.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun NavigationRail(
  items: List<String>,
  selectedIndex: Int,
  onSelectedIndexChange: (Int) -> Unit,
  attrs: AttrBuilderContext<HTMLUListElement>? = null
) {
  Ul(attrs = {
    daisy(Daisy.Navigation.Menu, extra = "rounded-box bg-base-200 p-2")
    attrs?.invoke(this)
  }) {
    items.forEachIndexed { index, item ->
      Li {
        A(attrs = {
          if (selectedIndex == index) daisy(Daisy.Navigation.MenuActive)
          onClick {
            it.preventDefault()
            onSelectedIndexChange(index)
          }
        }) { Text(item) }
      }
    }
  }
}
