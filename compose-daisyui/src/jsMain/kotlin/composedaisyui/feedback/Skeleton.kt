package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A skeleton loading placeholder for representing loading content shapes.
 *
 * @see <a href="https://daisyui.com/components/skeleton/">daisyUI Skeleton docs</a>
 *
 * @param attrs Additional HTML attributes (e.g., sizing classes like `w-24 h-4`).
 */
@Composable
public fun Skeleton(
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Feedback.Skeleton)
    attrs?.invoke(this)
  })
}
