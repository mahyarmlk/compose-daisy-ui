package composedaisyui.misc

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLAnchorElement

/**
 * A styled anchor link with optional color, hover variant, and custom content.
 *
 * @see <a href="https://daisyui.com/components/link/">daisyUI Link docs</a>
 *
 * @param text The link text content.
 * @param href The link target URL.
 * @param color Optional semantic color.
 * @param variant The link style variant.
 * @param attrs Additional HTML attributes.
 * @param content Optional custom link content. When omitted, [text] is rendered.
 */
@Composable
public fun Link(
  text: String? = null,
  href: String,
  color: UiColor? = null,
  variant: LinkVariant = LinkVariant.Default,
  attrs: AttrBuilderContext<HTMLAnchorElement>? = null,
  content: ContentBuilder<HTMLAnchorElement>? = null
) {
  A(attrs = {
    daisy(
      Daisy.Display.Link,
      color?.let { color("link", it.toDaisyColor()) },
      if (variant == LinkVariant.Hover) Daisy.Display.LinkHover else null
    )
    href(href)
    attrs?.invoke(this)
  }) {
    if (content != null) {
      content(this)
    } else {
      text?.let { Text(it) }
    }
  }
}
