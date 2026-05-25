package composedaisyui.actions

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.w3c.dom.HTMLButtonElement

/**
 * An icon-only button, typically square or circular, with an accessible label.
 *
 * @see <a href="https://daisyui.com/components/button/">daisyUI Button docs</a>
 *
 * @param ariaLabel Accessible label for screen readers.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param variant Visual variant style (defaults to Ghost).
 * @param shape Shape modifier (defaults to Square).
 * @param enabled Whether the button is interactive.
 * @param onClick Click handler.
 * @param attrs Additional HTML attributes.
 * @param icon The icon content composable.
 */
@Composable
public fun IconButton(
  ariaLabel: String,
  color: UiColor? = null,
  size: UiSize? = null,
  variant: UiVariant = UiVariant.Ghost,
  shape: ButtonShape = ButtonShape.Square,
  enabled: Boolean = true,
  onClick: ((SyntheticMouseEvent) -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  icon: ContentBuilder<HTMLButtonElement>
) {
  Button(
    color = color,
    size = size,
    variant = variant,
    shape = shape,
    enabled = enabled,
    onClick = onClick,
    attrs = {
      attr("aria-label", ariaLabel)
      attrs?.invoke(this)
    },
    content = icon
  )
}
