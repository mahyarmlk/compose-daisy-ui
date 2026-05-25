package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLUListElement

/**
 * A vertical timeline displaying chronological events with optional start and end markers.
 *
 * @see <a href="https://daisyui.com/components/timeline/">daisyUI Timeline docs</a>
 *
 * @param items The list of timeline entries.
 * @param compact If true, uses compact spacing between items.
 * @param orientation Optional orientation (horizontal/vertical).
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Timeline(
  items: List<TimelineItem>,
  compact: Boolean = false,
  orientation: UiOrientation? = null,
  attrs: AttrBuilderContext<HTMLUListElement>? = null
) {
  Ul(attrs = {
    daisy(Daisy.Data.Timeline, if (compact) Daisy.Data.TimelineCompact else null, orientation?.let { direction("timeline", it.toDaisyDirection()) })
    attrs?.invoke(this)
  }) {
    items.forEach { item ->
      Li {
        item.start?.let { Div({ daisy(Daisy.Data.TimelineStart) }) { Text(it) } }
        Div({ daisy(Daisy.Data.TimelineMiddle) }) { Text("\u25CF") }
        Div({ daisy(Daisy.Data.TimelineEnd, Daisy.Data.TimelineBox) }) {
          Text(item.title)
          item.body?.let { Div({ daisy(extra = "text-sm opacity-70") }) { Text(it) } }
        }
      }
    }
  }
}
