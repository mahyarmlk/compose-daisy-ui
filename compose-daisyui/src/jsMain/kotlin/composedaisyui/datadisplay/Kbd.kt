package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Element

/**
 * A keyboard key indicator for displaying shortcuts.
 *
 * @see <a href="https://daisyui.com/components/kbd/">daisyUI Kbd docs</a>
 *
 * @param text The key label text.
 * @param size Optional size preset.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Kbd(
  text: String,
  size: UiSize? = null,
  attrs: AttrBuilderContext<Element>? = null
) {
  DaisyGeneric("kbd", Daisy.Data.Kbd, size?.let { size("kbd", it.toDaisySize()) }, attrs = attrs) { Text(text) }
}
