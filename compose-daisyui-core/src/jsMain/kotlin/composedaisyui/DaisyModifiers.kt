package composedaisyui

public enum class DaisyColor(public val suffix: String) {
  Neutral("neutral"),
  Primary("primary"),
  Secondary("secondary"),
  Accent("accent"),
  Info("info"),
  Success("success"),
  Warning("warning"),
  Error("error")
}

public enum class DaisySize(public val suffix: String) {
  Xs("xs"),
  Sm("sm"),
  Md("md"),
  Lg("lg"),
  Xl("xl")
}

public enum class DaisyPlacement(public val suffix: String) {
  Start("start"),
  Center("center"),
  End("end"),
  Top("top"),
  Middle("middle"),
  Bottom("bottom"),
  Left("left"),
  Right("right")
}

public enum class DaisyDirection(public val suffix: String) {
  Horizontal("horizontal"),
  Vertical("vertical")
}

public fun color(component: String, color: DaisyColor): DaisyToken = cls("$component-${color.suffix}")
public fun size(component: String, size: DaisySize): DaisyToken = cls("$component-${size.suffix}")
public fun placement(component: String, placement: DaisyPlacement): DaisyToken = cls("$component-${placement.suffix}")
public fun direction(component: String, direction: DaisyDirection): DaisyToken = cls("$component-${direction.suffix}")
public fun part(name: String): DaisyToken = cls(name)
public fun utility(name: String): DaisyToken = cls(name)

public object DaisyMasks {
  public val Squircle: DaisyToken = cls("mask-squircle")
  public val Heart: DaisyToken = cls("mask-heart")
  public val Hexagon: DaisyToken = cls("mask-hexagon")
  public val Hexagon2: DaisyToken = cls("mask-hexagon-2")
  public val Decagon: DaisyToken = cls("mask-decagon")
  public val Pentagon: DaisyToken = cls("mask-pentagon")
  public val Diamond: DaisyToken = cls("mask-diamond")
  public val Square: DaisyToken = cls("mask-square")
  public val Circle: DaisyToken = cls("mask-circle")
  public val Star: DaisyToken = cls("mask-star")
  public val Star2: DaisyToken = cls("mask-star-2")
  public val Triangle: DaisyToken = cls("mask-triangle")
  public val Triangle2: DaisyToken = cls("mask-triangle-2")
  public val Triangle3: DaisyToken = cls("mask-triangle-3")
  public val Triangle4: DaisyToken = cls("mask-triangle-4")
  public val Half1: DaisyToken = cls("mask-half-1")
  public val Half2: DaisyToken = cls("mask-half-2")
}

public object DaisyVariants {
  public val DrawerOpen: String = "is-drawer-open:"
  public val DrawerClose: String = "is-drawer-close:"
}

