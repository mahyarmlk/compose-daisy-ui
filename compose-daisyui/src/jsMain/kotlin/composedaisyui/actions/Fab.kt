package composedaisyui.actions

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A Floating Action Button container that positions child buttons in the bottom corner.
 *
 * The first direct child should be the main toggle button. Subsequent children
 * are the speed-dial action buttons.
 *
 * @see <a href="https://daisyui.com/components/fab/">daisyUI FAB docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Fab children (main trigger + action buttons).
 */
@Composable
public fun Fab(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.Fab)
    attrs?.invoke(this)
  }, content = content)
}
