package composedaisyui.mockup

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * A dialog modal overlay with a content box and optional action area.
 *
 * @see <a href="https://daisyui.com/components/modal/">daisyUI Modal docs</a>
 *
 * @param open Whether the modal is visible.
 * @param actions Optional action buttons rendered at the bottom of the modal box.
 * @param placement Where the modal box appears vertically.
 * @param attrs Additional HTML attributes.
 * @param content The modal body content.
 */
@Composable
public fun Modal(
  open: Boolean,
  actions: (@Composable () -> Unit)? = null,
  placement: ModalPlacement? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>
) {
  Div(attrs = {
    daisy(
      Daisy.Display.Modal,
      placement?.let { placement("modal", it.toDaisyPlacement()) },
      if (open) Daisy.Display.ModalOpen else null
    )
    attrs?.invoke(this)
  }) {
    Div({ daisy(Daisy.Display.ModalBox) }) {
      content(this)
      actions?.let { Div({ daisy(Daisy.Display.ModalAction) }) { it() } }
    }
  }
}
