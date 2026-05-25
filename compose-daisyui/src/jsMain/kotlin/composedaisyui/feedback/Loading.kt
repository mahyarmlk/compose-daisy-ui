package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.loadingToken
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLSpanElement

/**
 * An animated loading indicator with multiple shape options.
 *
 * @see <a href="https://daisyui.com/components/loading/">daisyUI Loading docs</a>
 *
 * @param shape The animation style (spinner, dots, ring, ball, bars, infinity).
 * @param size Optional size preset.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Loading(
  shape: LoadingShape = LoadingShape.Spinner,
  size: UiSize? = null,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null
) {
  Span(attrs = {
    daisy(
      Daisy.Feedback.Loading,
      shape.loadingToken(),
      size?.let { size("loading", it.toDaisySize()) })
    attrs?.invoke(this)
  })
}
