package composedaisyui.navigation

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A top navigation bar with start, center, and end content sections.
 *
 * @see <a href="https://daisyui.com/components/navbar/">daisyUI Navbar docs</a>
 *
 * @param start Content aligned to the left of the navbar.
 * @param center Content aligned to the center of the navbar.
 * @param end Content aligned to the right of the navbar.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Navbar(
  start: (@Composable () -> Unit)? = null,
  center: (@Composable () -> Unit)? = null,
  end: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Layout.Navbar)
    attrs?.invoke(this)
  }) {
    start?.let { Div({ daisy(Daisy.Layout.NavbarStart) }) { it() } }
    center?.let { Div({ daisy(Daisy.Layout.NavbarCenter) }) { it() } }
    end?.let { Div({ daisy(Daisy.Layout.NavbarEnd) }) { it() } }
  }
}
