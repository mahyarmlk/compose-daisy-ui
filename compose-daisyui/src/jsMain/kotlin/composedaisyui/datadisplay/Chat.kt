package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A chat bubble with optional avatar image, header, footer, and placement control.
 *
 * @see <a href="https://daisyui.com/components/chat/">daisyUI Chat docs</a>
 *
 * @param placement Which side the bubble appears on (start or end).
 * @param image Optional avatar/image area.
 * @param header Optional header above the bubble.
 * @param footer Optional footer below the bubble.
 * @param attrs Additional HTML attributes.
 * @param content The chat message content.
 */
@Composable
public fun Chat(
  placement: ChatPlacement = ChatPlacement.Start,
  image: (@Composable () -> Unit)? = null,
  header: (@Composable () -> Unit)? = null,
  footer: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.Chat, cls("chat-${placement.name.lowercase()}"))
    attrs?.invoke(this)
  }) {
    image?.let { Div({ daisy(Daisy.Display.ChatImage) }) { it() } }
    header?.let { Div({ daisy(Daisy.Display.ChatHeader) }) { it() } }
    Div({ daisy(Daisy.Display.ChatBubble) }) { content(this) }
    footer?.let { Div({ daisy(Daisy.Display.ChatFooter) }) { it() } }
  }
}
