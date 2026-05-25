package composedaisyui.app

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement

/**
 * A sticky top navigation bar with title, optional navigation icon, and action slots.
 *
 * Built on daisyUI's [navbar](https://daisyui.com/components/navbar/) component.
 *
 * @param title The title text displayed in the app bar.
 * @param navigationIcon Optional composable rendered at the leading edge.
 * @param actions Optional composable rendered at the trailing edge.
 * @param attrs Additional HTML attributes for the root `<header>`.
 */
@Composable
public fun TopAppBar(
  title: String,
  navigationIcon: (@Composable () -> Unit)? = null,
  actions: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLElement>? = null
) {
  Header(attrs = {
    daisy(Daisy.Layout.Navbar, extra = "sticky top-0 z-20 bg-base-100/95 shadow-sm backdrop-blur")
    attrs?.invoke(this)
  }) {
    Div({ daisy(Daisy.Layout.NavbarStart, extra = "gap-2") }) {
      navigationIcon?.invoke()
      Span({ daisy(extra = "text-lg font-semibold") }) { Text(title) }
    }
    Div({ daisy(Daisy.Layout.NavbarEnd, extra = "gap-2") }) {
      actions?.invoke()
    }
  }
}
