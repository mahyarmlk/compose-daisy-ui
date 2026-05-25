package composedaisyui.layout

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A scrollable carousel container for displaying content in a horizontal or vertical strip.
 *
 * @see <a href="https://daisyui.com/components/carousel/">daisyUI Carousel docs</a>
 *
 * @param orientation Scroll direction.
 * @param attrs Additional HTML attributes.
 * @param content Carousel slides (typically [CarouselItem] elements).
 */
@Composable
public fun Carousel(
  orientation: UiOrientation? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(
      Daisy.Display.Carousel,
      orientation?.let { direction("carousel", it.toDaisyDirection()) }
    )
    attrs?.invoke(this)
  }, content = content)
}

/**
 * A single slide item within a [Carousel].
 *
 * @see [Carousel]
 *
 * @param attrs Additional HTML attributes.
 * @param content Slide content.
 */
@Composable
public fun CarouselItem(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Display.CarouselItem)
    attrs?.invoke(this)
  }, content = content)
}
