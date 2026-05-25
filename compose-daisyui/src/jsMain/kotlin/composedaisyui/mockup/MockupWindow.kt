package composedaisyui.mockup

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * An operating system window mockup with title bar controls.
 *
 * @see <a href="https://daisyui.com/components/mockup-window/">daisyUI Mockup Window docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content The window body content.
 */
@Composable
public fun MockupWindow(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.MockupWindow)
    attrs?.invoke(this)
  }, content = content)
}
