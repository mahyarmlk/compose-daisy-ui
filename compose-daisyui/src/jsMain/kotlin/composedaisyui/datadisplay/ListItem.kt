package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLLIElement

/**
 * A single row in a [UiList], supporting leading content, headline, supporting text, and trailing content.
 *
 * @see <a href="https://daisyui.com/components/list/">daisyUI List docs</a>
 *
 * @param headline Primary text for the list item.
 * @param supporting Optional secondary text.
 * @param leading Optional composable rendered at the start (icon, avatar).
 * @param trailing Optional composable rendered at the end (action, badge).
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun ListItem(
  headline: String,
  supporting: String? = null,
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLLIElement>? = null
) {
  Li(attrs = {
    daisy(extra = "list-row")
    attrs?.invoke(this)
  }) {
    leading?.invoke()
    Div {
      Div({ daisy(extra = "font-medium") }) { Text(headline) }
      supporting?.let { Div({ daisy(extra = "text-sm opacity-70") }) { Text(it) } }
    }
    trailing?.invoke()
  }
}
