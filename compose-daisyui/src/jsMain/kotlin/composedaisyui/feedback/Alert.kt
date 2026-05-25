package composedaisyui.feedback

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.alertToken
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * An alert banner for displaying important messages with optional icon and actions.
 *
 * @see <a href="https://daisyui.com/components/alert/">daisyUI Alert docs</a>
 *
 * @param title Optional bold heading for the alert.
 * @param message The main alert message text.
 * @param color Semantic color indicating the alert type.
 * @param variant Visual style variant.
 * @param icon Optional icon composable rendered before the message.
 * @param actions Optional action buttons at the end of the alert.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Alert(
  title: String? = null,
  message: String,
  color: UiColor = UiColor.Info,
  variant: AlertVariant = AlertVariant.Soft,
  icon: (@Composable () -> Unit)? = null,
  actions: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(Daisy.Alert.Alert, color("alert", color.toDaisyColor()), variant.alertToken())
    attrs?.invoke(this)
  }) {
    icon?.invoke()
    Div {
      title?.let { Div({ daisy(extra = "font-semibold") }) { Text(it) } }
      Div({ daisy(extra = if (title == null) "" else "text-sm") }) { Text(message) }
    }
    actions?.invoke()
  }
}
