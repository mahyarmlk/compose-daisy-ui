package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLUListElement

/**
 * A vertical or horizontal menu list with active and disabled item states.
 *
 * @see <a href="https://daisyui.com/components/menu/">daisyUI Menu docs</a>
 *
 * @param items The menu item definitions.
 * @param onItemClick Callback with the clicked item index.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Menu(
  items: List<MenuItem>,
  onItemClick: (Int) -> Unit = {},
  attrs: AttrBuilderContext<HTMLUListElement>? = null
) {
  Ul(attrs = {
    daisy(Daisy.Navigation.Menu)
    attrs?.invoke(this)
  }) {
    items.forEachIndexed { index, item ->
      Li {
        if (item.href == null) {
          A(attrs = {
            daisy(
              if (item.active) Daisy.Navigation.MenuActive else null,
              if (item.disabled) Daisy.Navigation.MenuDisabled else null
            )
            onClick {
              it.preventDefault()
              if (!item.disabled) onItemClick(index)
            }
          }) { Text(item.label) }
        } else {
          A(attrs = {
            daisy(
              if (item.active) Daisy.Navigation.MenuActive else null,
              if (item.disabled) Daisy.Navigation.MenuDisabled else null
            )
            href(item.href)
          }) { Text(item.label) }
        }
      }
    }
  }
}
