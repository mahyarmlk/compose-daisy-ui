package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.cardToken
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * A styled card container with optional title, subtitle, and action area.
 *
 * @see <a href="https://daisyui.com/components/card/">daisyUI Card docs</a>
 *
 * @param title Optional card heading.
 * @param subtitle Optional secondary text under the title.
 * @param variant Visual variant (border, dash, side, image-full).
 * @param size Optional size preset.
 * @param actions Composable rendered in the card footer/action area.
 * @param attrs Additional HTML attributes.
 * @param content Main card body content.
 */
@Composable
public fun Card(
  title: String? = null,
  subtitle: String? = null,
  variant: CardVariant = CardVariant.Plain,
  size: UiSize? = null,
  actions: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(
      Daisy.Card.Card,
      variant.cardToken(),
      size?.let { size("card", it.toDaisySize()) },
      extra = "bg-base-100"
    )
    attrs?.invoke(this)
  }) {
    Div({ daisy(Daisy.Card.Body) }) {
      if (title != null || subtitle != null) {
        Div({ daisy(extra = "space-y-1") }) {
          title?.let { Div({ daisy(Daisy.Card.Title) }) { Text(it) } }
          subtitle?.let { Div({ daisy(extra = "text-sm text-base-content/70") }) { Text(it) } }
        }
      }
      content(this)
      actions?.let {
        Div({ daisy(Daisy.Card.Actions, extra = "justify-end") }) { it() }
      }
    }
  }
}
