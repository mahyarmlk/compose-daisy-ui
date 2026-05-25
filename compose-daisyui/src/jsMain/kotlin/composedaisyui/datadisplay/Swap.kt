package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.swapToken
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.w3c.dom.HTMLLabelElement

/**
 * A toggle that animates between two visual states (on/off) with optional rotation or flip.
 *
 * @see <a href="https://daisyui.com/components/swap/">daisyUI Swap docs</a>
 *
 * @param checked Whether the swap is in the "on" state.
 * @param onCheckedChange Callback when the state changes.
 * @param on Composable for the "on" (active) visual.
 * @param off Composable for the "off" (inactive) visual.
 * @param variant Visual animation variant (rotate or flip).
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Swap(
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
  on: @Composable () -> Unit,
  off: @Composable () -> Unit,
  variant: SwapVariant = SwapVariant.Default,
  attrs: AttrBuilderContext<HTMLLabelElement>? = null
) {
  Label(attrs = {
    daisy(Daisy.Display.Swap, variant.swapToken())
    attrs?.invoke(this)
  }) {
    Input(type = InputType.Checkbox, attrs = {
      checked(checked)
      onChange { onCheckedChange(it.value) }
    })
    Div({ daisy(Daisy.Display.SwapOn) }) { on() }
    Div({ daisy(Daisy.Display.SwapOff) }) { off() }
  }
}
