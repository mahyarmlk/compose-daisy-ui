package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLUListElement

/**
 * A steps indicator showing progression through a multi-step process.
 *
 * @see <a href="https://daisyui.com/components/steps/">daisyUI Steps docs</a>
 *
 * @param items The step definitions.
 * @param orientation Optional layout direction.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Steps(
  items: List<StepItem>,
  orientation: UiOrientation? = null,
  attrs: AttrBuilderContext<HTMLUListElement>? = null
) {
  Ul(attrs = {
    daisy(Daisy.Navigation.Steps, orientation?.let { direction("steps", it.toDaisyDirection()) })
    attrs?.invoke(this)
  }) {
    items.forEach { item ->
      Li(attrs = { daisy(Daisy.Navigation.Step, if (item.active) color("step", DaisyColor.Primary) else null) }) {
        item.icon?.let { Span({ daisy(Daisy.Navigation.StepIcon) }) { Text(it) } }
        Text(item.label)
      }
    }
  }
}
