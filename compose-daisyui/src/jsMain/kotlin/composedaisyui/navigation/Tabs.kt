package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * A tab bar with configurable items and an active selection index.
 *
 * @see <a href="https://daisyui.com/components/tab/">daisyUI Tab docs</a>
 *
 * @param items Tab label strings.
 * @param selectedIndex The zero-based index of the active tab.
 * @param onSelectedIndexChange Callback when a tab is clicked.
 * @param boxed If true, wraps tabs in a bordered box.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Tabs(
  items: List<String>,
  selectedIndex: Int,
  onSelectedIndexChange: (Int) -> Unit,
  boxed: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Navigation.Tabs, if (boxed) Daisy.Navigation.TabsBox else null)
    attrs?.invoke(this)
  }) {
    items.forEachIndexed { index, item ->
      A(attrs = {
        daisy(
          Daisy.Navigation.Tab,
          if (selectedIndex == index) Daisy.Navigation.TabActive else null
        )
        attr("role", "tab")
        onClick {
          it.preventDefault()
          onSelectedIndexChange(index)
        }
      }) { Text(item) }
    }
  }
}
