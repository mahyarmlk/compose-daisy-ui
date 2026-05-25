package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

/**
 * A breadcrumb trail showing the user's current location in a hierarchy.
 *
 * @see <a href="https://daisyui.com/components/breadcrumbs/">daisyUI Breadcrumbs docs</a>
 *
 * @param items The list of breadcrumb segments. Items without an href render as plain text.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Breadcrumbs(
  items: List<BreadcrumbItem>,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Layout.Breadcrumbs)
    attrs?.invoke(this)
  }) {
    Ul {
      items.forEach { item ->
        Li {
          if (item.href == null) {
            Text(item.label)
          } else {
            A(attrs = { href(item.href) }) { Text(item.label) }
          }
        }
      }
    }
  }
}
