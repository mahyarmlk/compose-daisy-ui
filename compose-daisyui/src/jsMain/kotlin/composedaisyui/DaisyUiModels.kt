package composedaisyui

public enum class UiColor {
  Neutral,
  Primary,
  Secondary,
  Accent,
  Info,
  Success,
  Warning,
  Error
}

public enum class UiSize {
  Xs,
  Sm,
  Md,
  Lg,
  Xl
}

public enum class UiVariant {
  Solid,
  Outline,
  Soft,
  Ghost,
  Link,
  Dash
}

public enum class UiOrientation {
  Horizontal,
  Vertical
}

public enum class UiPlacement {
  Start,
  Center,
  End,
  Top,
  Bottom,
  Left,
  Right
}

public enum class ButtonShape {
  Default,
  Wide,
  Block,
  Square,
  Circle
}

public enum class CardVariant {
  Plain,
  Border,
  Dash,
  Side,
  ImageFull
}

public enum class AlertVariant {
  Solid,
  Outline,
  Soft,
  Dash
}

public enum class LoadingShape {
  Spinner,
  Dots,
  Ring,
  Ball,
  Bars,
  Infinity
}

public enum class LinkVariant {
  Default,
  Hover
}

public enum class ChatPlacement {
  Start,
  End
}

public enum class TooltipPlacement {
  Top,
  Bottom,
  Left,
  Right
}

public enum class ToastPlacement {
  Start,
  Center,
  End,
  Top,
  Middle,
  Bottom
}

public enum class ModalPlacement {
  Start,
  Middle,
  End,
  Bottom
}

public enum class DividerPlacement {
  Start,
  End
}

public enum class TimelinePlacement {
  Start,
  Middle,
  End
}

public enum class MaskShape {
  Squircle,
  Heart,
  Hexagon,
  Hexagon2,
  Decagon,
  Pentagon,
  Diamond,
  Square,
  Circle,
  Star,
  Star2,
  Triangle,
  Triangle2,
  Triangle3,
  Triangle4,
  Half1,
  Half2
}

public enum class SwapVariant {
  Default,
  Rotate,
  Flip
}

public enum class RatingShape {
  Star,
  Star2,
  Heart
}

public data class BreadcrumbItem(
  public val label: String,
  public val href: String? = null
)

public data class StepItem(
  public val label: String,
  public val active: Boolean = false,
  public val icon: String? = null
)

public data class DockItem(
  public val label: String,
  public val active: Boolean = false,
  public val icon: String? = null
)

public data class StatItem(
  public val title: String,
  public val value: String,
  public val description: String? = null
)

public data class TimelineItem(
  public val title: String,
  public val body: String? = null,
  public val start: String? = null,
  public val end: String? = null
)

public data class MenuItem(
  public val label: String,
  public val active: Boolean = false,
  public val disabled: Boolean = false,
  public val href: String? = null
)

public data class PaginationItem(
  public val label: String,
  public val active: Boolean = false,
  public val disabled: Boolean = false
)

public data class SelectOption(
  public val value: String,
  public val label: String,
  public val disabled: Boolean = false
)

internal fun UiColor.toDaisyColor(): DaisyColor = when (this) {
  UiColor.Neutral -> DaisyColor.Neutral
  UiColor.Primary -> DaisyColor.Primary
  UiColor.Secondary -> DaisyColor.Secondary
  UiColor.Accent -> DaisyColor.Accent
  UiColor.Info -> DaisyColor.Info
  UiColor.Success -> DaisyColor.Success
  UiColor.Warning -> DaisyColor.Warning
  UiColor.Error -> DaisyColor.Error
}

internal fun UiSize.toDaisySize(): DaisySize = when (this) {
  UiSize.Xs -> DaisySize.Xs
  UiSize.Sm -> DaisySize.Sm
  UiSize.Md -> DaisySize.Md
  UiSize.Lg -> DaisySize.Lg
  UiSize.Xl -> DaisySize.Xl
}

internal fun UiOrientation.toDaisyDirection(): DaisyDirection = when (this) {
  UiOrientation.Horizontal -> DaisyDirection.Horizontal
  UiOrientation.Vertical -> DaisyDirection.Vertical
}

internal fun UiPlacement.toDaisyPlacement(): DaisyPlacement = when (this) {
  UiPlacement.Start -> DaisyPlacement.Start
  UiPlacement.Center -> DaisyPlacement.Center
  UiPlacement.End -> DaisyPlacement.End
  UiPlacement.Top -> DaisyPlacement.Top
  UiPlacement.Bottom -> DaisyPlacement.Bottom
  UiPlacement.Left -> DaisyPlacement.Left
  UiPlacement.Right -> DaisyPlacement.Right
}

internal fun ModalPlacement.toDaisyPlacement(): DaisyPlacement = when (this) {
  ModalPlacement.Start -> DaisyPlacement.Start
  ModalPlacement.Middle -> DaisyPlacement.Middle
  ModalPlacement.End -> DaisyPlacement.End
  ModalPlacement.Bottom -> DaisyPlacement.Bottom
}
