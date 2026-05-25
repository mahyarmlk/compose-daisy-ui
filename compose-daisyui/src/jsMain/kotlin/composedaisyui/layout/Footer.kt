package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.Element

/**
 * A page footer with navigation sections and optional center alignment.
 *
 * @see <a href="https://daisyui.com/components/footer/">daisyUI Footer docs</a>
 *
 * @param center If true, centers footer content.
 * @param orientation Optional layout direction.
 * @param attrs Additional HTML attributes.
 * @param content Footer content, typically `<nav>` sections.
 */
@Composable
public fun Footer(
  center: Boolean = false,
  orientation: UiOrientation? = null,
  attrs: AttrBuilderContext<Element>? = null,
  content: ContentBuilder<Element>
) {
  DaisyGeneric(
    "footer",
    Daisy.Layout.Footer,
    if (center) Daisy.Layout.FooterCenter else null,
    orientation?.let { direction("footer", it.toDaisyDirection()) },
    attrs = attrs,
    content = content
  )
}
