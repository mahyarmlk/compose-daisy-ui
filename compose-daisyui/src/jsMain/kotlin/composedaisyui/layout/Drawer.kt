package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A slide-out drawer layout with a toggleable sidebar.
 *
 * @see <a href="https://daisyui.com/components/drawer/">daisyUI Drawer docs</a>
 *
 * @param open Whether the drawer sidebar is currently visible.
 * @param drawerContent The sidebar content to show when the drawer is open.
 * @param end If true, the drawer opens from the right side.
 * @param attrs Additional HTML attributes.
 * @param content The main page content.
 */
@Composable
public fun Drawer(
  open: Boolean,
  drawerContent: @Composable () -> Unit,
  end: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Layout.Drawer, if (open) Daisy.Layout.DrawerOpen else null, if (end) Daisy.Layout.DrawerEnd else null)
    attrs?.invoke(this)
  }) {
    Div({ daisy(Daisy.Layout.DrawerContent) }) { content(this) }
    Div({ daisy(Daisy.Layout.DrawerSide) }) {
      Div({ daisy(Daisy.Layout.DrawerOverlay) })
      drawerContent()
    }
  }
}
