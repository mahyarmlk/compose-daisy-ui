package composedaisyui.actions

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import composedaisyui.*
import composedaisyui.internal.*
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

/**
 * A styled button with support for colors, sizes, variants, shapes, loading state,
 * and leading/trailing content slots.
 *
 * @see <a href="https://daisyui.com/components/button/">daisyUI Button docs</a>
 *
 * @param text Optional text label for the button.
 * @param color Optional semantic color.
 * @param size Optional size preset.
 * @param variant Visual variant style.
 * @param shape Shape modifier (wide, block, square, circle).
 * @param enabled Whether the button is interactive.
 * @param loading If true, shows a spinner and disables the button.
 * @param onClick Click handler.
 * @param leading Composable rendered before the text.
 * @param trailing Composable rendered after the text.
 * @param attrs Additional HTML attributes.
 * @param content Additional inline content slot.
 */
@Composable
public fun Button(
  text: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  variant: UiVariant = UiVariant.Solid,
  shape: ButtonShape = ButtonShape.Default,
  enabled: Boolean = true,
  loading: Boolean = false,
  onClick: ((SyntheticMouseEvent) -> Unit)? = null,
  leading: (@Composable () -> Unit)? = null,
  trailing: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ContentBuilder<HTMLButtonElement>? = null
) {
  Button(attrs = {
    type(ButtonType.Button)
    daisy(
      Daisy.Button.Btn,
      color?.let { color("btn", it.toDaisyColor()) },
      size?.let { size("btn", it.toDaisySize()) },
      variant.buttonToken(),
      shape.buttonToken(),
      if (!enabled) Daisy.Button.Disabled else null
    )
    if (!enabled || loading) disabled()
    onClick?.let { onClick(it) }
    attrs?.invoke(this)
  }) {
    if (loading) composedaisyui.feedback.Loading(shape = composedaisyui.LoadingShape.Spinner, size = UiSize.Sm)
    leading?.invoke()
    text?.let { Text(it) }
    content?.invoke(this)
    trailing?.invoke()
  }
}
