package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * A row of statistic cards, each with a title, value, and optional description.
 *
 * @see <a href="https://daisyui.com/components/stat/">daisyUI Stats docs</a>
 *
 * @param items The list of stat items to display.
 * @param orientation Optional layout direction. Defaults to daisyUI's horizontal layout.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Stats(
  items: List<StatItem>,
  orientation: UiOrientation? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(
      Daisy.Data.Stats,
      orientation?.let { direction("stats", it.toDaisyDirection()) }
    )
    attrs?.invoke(this)
  }) {
    items.forEach { item ->
      Div({ daisy(Daisy.Data.Stat) }) {
        Div({ daisy(Daisy.Data.StatTitle) }) { Text(item.title) }
        Div({ daisy(Daisy.Data.StatValue) }) { Text(item.value) }
        item.description?.let { Div({ daisy(Daisy.Data.StatDesc) }) { Text(it) } }
      }
    }
  }
}
