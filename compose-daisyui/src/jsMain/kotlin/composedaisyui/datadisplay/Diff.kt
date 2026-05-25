package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A side-by-side comparison component with a draggable divider (resizer).
 *
 * @see <a href="https://daisyui.com/components/diff/">daisyUI Diff docs</a>
 *
 * @param first The first (left/before) content.
 * @param second The second (right/after) content.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Diff(
  first: @Composable () -> Unit,
  second: @Composable () -> Unit,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Display.Diff, extra = "aspect-video")
    attrs?.invoke(this)
  }) {
    Div({ daisy(Daisy.Display.DiffItem1) }) { first() }
    Div({ daisy(Daisy.Display.DiffItem2) }) { second() }
    Div({ daisy(Daisy.Display.DiffResizer) })
  }
}
