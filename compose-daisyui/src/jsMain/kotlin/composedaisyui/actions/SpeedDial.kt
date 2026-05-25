package composedaisyui.actions

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A speed-dial FAB that reveals action buttons and optionally a main/close action.
 *
 * @see <a href="https://daisyui.com/components/fab/">daisyUI FAB docs</a>
 *
 * @param mainAction The primary action shown when the FAB is open.
 * @param closeAction Optional close/exit action shown when the FAB is open.
 * @param attrs Additional HTML attributes for the outer FAB container.
 * @param actions Speed-dial action buttons.
 */
@Composable
public fun SpeedDial(
  mainAction: @Composable () -> Unit,
  closeAction: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  actions: ContentBuilder<HTMLDivElement>
) {
  Fab(attrs = attrs) {
    closeAction?.let { Div({ daisy(Daisy.Display.FabClose) }) { it() } }
    actions(this)
    Div({ daisy(Daisy.Display.FabMainAction) }) { mainAction() }
  }
}
