package composedaisyui.mockup

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A browser window mockup with an optional toolbar (address bar area).
 *
 * @see <a href="https://daisyui.com/components/mockup-browser/">daisyUI Mockup Browser docs</a>
 *
 * @param toolbar Optional toolbar content (e.g., URL bar, controls).
 * @param attrs Additional HTML attributes.
 * @param content The browser window body content.
 */
@Composable
public fun MockupBrowser(
  toolbar: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.MockupBrowser)
    attrs?.invoke(this)
  }) {
    toolbar?.let { Div({ daisy(Daisy.Display.MockupBrowserToolbar) }) { it() } }
    content(this)
  }
}
