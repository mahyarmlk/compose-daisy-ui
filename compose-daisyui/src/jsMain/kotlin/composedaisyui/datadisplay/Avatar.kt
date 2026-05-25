package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLDivElement

/**
 * An avatar thumbnail with optional online/offline indicator and placeholder text.
 *
 * @see <a href="https://daisyui.com/components/avatar/">daisyUI Avatar docs</a>
 *
 * @param placeholder Text initials shown when no image is provided.
 * @param online If true, shows a green online indicator.
 * @param offline If true, shows a gray offline indicator.
 * @param attrs Additional HTML attributes.
 * @param content Optional content (e.g., an `<img>` for a custom avatar image).
 */
@Composable
public fun Avatar(
  placeholder: String? = null,
  online: Boolean = false,
  offline: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(
      Daisy.Avatar.Avatar,
      if (placeholder != null) Daisy.Avatar.Placeholder else null,
      if (online) Daisy.Avatar.Online else null,
      if (offline) Daisy.Avatar.Offline else null
    )
    attrs?.invoke(this)
  }) {
    if (placeholder != null) {
      Div({ daisy(extra = "bg-neutral text-neutral-content w-12 rounded-full") }) {
        Span { Text(placeholder) }
      }
    }
    content?.invoke(this)
  }
}
