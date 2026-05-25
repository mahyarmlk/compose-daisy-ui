package composedaisyui.app

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A themed surface container that applies background color and optional elevation.
 *
 * @see <a href="https://daisyui.com/components/">daisyUI docs</a>
 *
 * @param color Optional semantic color for the surface background.
 *   When null, uses `bg-base-100` or `bg-base-200` based on [tonal].
 * @param tonal If true and [color] is null, applies a slightly elevated background tone.
 * @param elevated If true, adds a subtle box shadow.
 * @param attrs Additional HTML attributes for the underlying `<div>`.
 * @param content Content composable to render inside the surface.
 */
@Composable
public fun Surface(
  color: UiColor? = null,
  tonal: Boolean = false,
  elevated: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  val tone = when (color) {
    null -> if (tonal) "bg-base-200" else "bg-base-100"
    UiColor.Neutral -> "bg-neutral text-neutral-content"
    UiColor.Primary -> "bg-primary text-primary-content"
    UiColor.Secondary -> "bg-secondary text-secondary-content"
    UiColor.Accent -> "bg-accent text-accent-content"
    UiColor.Info -> "bg-info text-info-content"
    UiColor.Success -> "bg-success text-success-content"
    UiColor.Warning -> "bg-warning text-warning-content"
    UiColor.Error -> "bg-error text-error-content"
  }
  Div(attrs = {
    daisy(extra = listOf(tone, if (elevated) "shadow-sm" else "").joinToString(" "))
    attrs?.invoke(this)
  }, content = content)
}
