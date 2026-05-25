package composedaisyui.mockup

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * An iPhone-style phone mockup with camera notch and display area.
 *
 * @see <a href="https://daisyui.com/components/mockup-phone/">daisyUI Mockup Phone docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Content rendered inside the phone display area.
 */
@Composable
public fun MockupPhone(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.MockupPhone)
    attrs?.invoke(this)
  }) {
    Div({ daisy(Daisy.Display.MockupPhoneCamera) })
    Div({ daisy(Daisy.Display.MockupPhoneDisplay) }) { content(this) }
  }
}
