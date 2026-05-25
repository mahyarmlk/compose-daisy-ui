package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.badgeToken
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

/**
 * A small status badge for labeling or tagging content.
 *
 * @see <a href="https://daisyui.com/components/badge/">daisyUI Badge docs</a>
 *
 * @param text The badge label text.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param variant Visual variant style.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Badge(
  text: String,
  color: UiColor? = null,
  size: UiSize? = null,
  variant: UiVariant = UiVariant.Solid,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null
) {
  Span(attrs = {
    daisy(
      Daisy.Badge.Badge,
      color?.let { color("badge", it.toDaisyColor()) },
      size?.let { size("badge", it.toDaisySize()) },
      variant.badgeToken()
    )
    attrs?.invoke(this)
  }) { Text(text) }
}
