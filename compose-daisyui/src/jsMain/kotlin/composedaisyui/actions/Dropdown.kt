package composedaisyui.actions

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLUListElement

/**
 * A dropdown menu that opens on click or hover with configurable placement.
 *
 * @see <a href="https://daisyui.com/components/dropdown/">daisyUI Dropdown docs</a>
 *
 * @param trigger The clickable trigger element.
 * @param placement Preferred opening direction.
 * @param hover If true, opens on hover instead of click.
 * @param open If true, forces the dropdown to stay open.
 * @param attrs Additional HTML attributes for the outer container.
 * @param content Menu content, typically `<li>` items.
 */
@Composable
public fun Dropdown(
  trigger: @Composable () -> Unit,
  placement: UiPlacement? = null,
  hover: Boolean = false,
  open: Boolean = false,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLUListElement>
) {
  Div(attrs = {
    daisy(
      Daisy.Navigation.Dropdown,
      placement?.let { placement("dropdown", it.toDaisyPlacement()) },
      if (hover) Daisy.Navigation.DropdownHover else null,
      if (open) Daisy.Navigation.DropdownOpen else null
    )
    attrs?.invoke(this)
  }) {
    Div({ attr("tabindex", "0"); attr("role", "button") }) { trigger() }
    Ul(attrs = {
      daisy(Daisy.Navigation.DropdownContent, Daisy.Navigation.Menu, extra = "z-10 w-52 rounded-box bg-base-100 p-2 shadow")
      attr("tabindex", "0")
    }, content = content)
  }
}
