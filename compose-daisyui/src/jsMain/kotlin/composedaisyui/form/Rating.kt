package composedaisyui.form

import androidx.compose.runtime.Composable
import composedaisyui.*
import composedaisyui.internal.ratingMaskToken
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLDivElement

/**
 * A star (or heart) rating component using radio buttons with mask shapes.
 *
 * @see <a href="https://daisyui.com/components/rating/">daisyUI Rating docs</a>
 *
 * @param value The current rating value (1-based index).
 * @param max The maximum number of rating items.
 * @param name The radio group name (must be unique per rating instance).
 * @param shape The shape of each rating item (star, star2, heart).
 * @param maskHalf If true, enables half-star rating using `rating-half`.
 * @param size Optional size preset.
 * @param onValueChange Callback with the selected rating index.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun Rating(
  value: Int,
  max: Int = 5,
  name: String = "rating",
  shape: RatingShape = RatingShape.Star,
  maskHalf: Boolean = false,
  size: UiSize? = null,
  onValueChange: ((Int) -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null
) {
  Div(attrs = {
    daisy(
      Daisy.Display.Rating,
      size?.let { size("rating", it.toDaisySize()) },
      if (maskHalf) Daisy.Display.RatingHalf else null
    )
    attrs?.invoke(this)
  }) {
    (1..max).forEach { index ->
      Input(type = InputType.Radio, attrs = {
        daisy(Daisy.Display.Mask, shape.ratingMaskToken())
        attr("name", name)
        checked(index == value)
        onChange { if (it.value) onValueChange?.invoke(index) }
      })
    }
  }
}
