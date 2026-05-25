package composedaisyui.mockup

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Pre
import org.w3c.dom.HTMLPreElement

/**
 * A code editor mockup for displaying syntax-highlighted code blocks.
 *
 * @see <a href="https://daisyui.com/components/mockup-code/">daisyUI Mockup Code docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Code lines, typically `<pre data-prefix="..."><code>...</code></pre>`.
 */
@Composable
public fun MockupCode(
  attrs: AttrBuilderContext<HTMLPreElement>? = null,
  content: ContentBuilder<HTMLPreElement>
) {
  Pre(attrs = {
    daisy(Daisy.Display.MockupCode)
    attrs?.invoke(this)
  }, content = content)
}
