package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A group container for stacking multiple [Avatar] components with an overlap effect.
 *
 * @see <a href="https://daisyui.com/components/avatar/">daisyUI Avatar docs</a>
 *
 * @param attrs Additional HTML attributes.
 * @param content Avatar composables to group together.
 */
@Composable
public fun AvatarGroup(
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(Daisy.Avatar.Group)
    attrs?.invoke(this)
  }, content = content)
}
