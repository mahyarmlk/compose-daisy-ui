package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.actions.Button
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * A bottom navigation dock bar with labeled buttons.
 *
 * @see <a href="https://daisyui.com/components/dock/">daisyUI Dock docs</a>
 *
 * @param items The dock navigation items.
 * @param onItemClick Callback with the clicked item index.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Dock(
  items: List<DockItem>,
  onItemClick: (Int) -> Unit,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Navigation.Dock)
    attrs?.invoke(this)
  }) {
    items.forEachIndexed { index, item ->
      Button(
        variant = UiVariant.Ghost,
        attrs = {
          daisy(if (item.active) Daisy.Navigation.DockActive else null)
          onClick { onItemClick(index) }
        }
      ) {
        item.icon?.let { Span { Text(it) } }
        Span({ daisy(Daisy.Navigation.DockLabel) }) { Text(item.label) }
      }
    }
  }
}
