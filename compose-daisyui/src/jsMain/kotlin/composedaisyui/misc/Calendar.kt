package composedaisyui.misc

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A calendar container for wrapping third-party calendar libraries (Cally, Pikaday, React Day Picker).
 *
 * @see <a href="https://daisyui.com/components/calendar/">daisyUI Calendar docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content The calendar widget content.
 */
@Composable
public fun Calendar(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Form.Calendar)
    attrs?.invoke(this)
  }, content = content)
}
