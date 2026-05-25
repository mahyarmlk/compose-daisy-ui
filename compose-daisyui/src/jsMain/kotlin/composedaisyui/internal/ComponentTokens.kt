package composedaisyui.internal

import composedaisyui.*

internal fun UiVariant.buttonToken(): DaisyToken? = when (this) {
  UiVariant.Solid -> null
  UiVariant.Outline -> Daisy.Button.Outline
  UiVariant.Soft -> Daisy.Button.Soft
  UiVariant.Ghost -> Daisy.Button.Ghost
  UiVariant.Link -> Daisy.Button.Link
  UiVariant.Dash -> Daisy.Button.Dash
}

internal fun UiVariant.badgeToken(): DaisyToken? = when (this) {
  UiVariant.Solid -> null
  UiVariant.Outline -> Daisy.Badge.Outline
  UiVariant.Soft -> Daisy.Badge.Soft
  UiVariant.Ghost -> Daisy.Badge.Ghost
  UiVariant.Link -> null
  UiVariant.Dash -> Daisy.Badge.Dash
}

internal fun ButtonShape.buttonToken(): DaisyToken? = when (this) {
  ButtonShape.Default -> null
  ButtonShape.Wide -> Daisy.Button.Wide
  ButtonShape.Block -> Daisy.Button.Block
  ButtonShape.Square -> Daisy.Button.Square
  ButtonShape.Circle -> Daisy.Button.Circle
}

internal fun CardVariant.cardToken(): DaisyToken? = when (this) {
  CardVariant.Plain -> null
  CardVariant.Border -> Daisy.Card.Border
  CardVariant.Dash -> Daisy.Card.Dash
  CardVariant.Side -> Daisy.Card.Side
  CardVariant.ImageFull -> Daisy.Card.ImageFull
}

internal fun AlertVariant.alertToken(): DaisyToken? = when (this) {
  AlertVariant.Solid -> null
  AlertVariant.Outline -> Daisy.Alert.Outline
  AlertVariant.Soft -> Daisy.Alert.Soft
  AlertVariant.Dash -> Daisy.Alert.Dash
}

internal fun LoadingShape.loadingToken(): DaisyToken = when (this) {
  LoadingShape.Spinner -> Daisy.Feedback.LoadingSpinner
  LoadingShape.Dots -> Daisy.Feedback.LoadingDots
  LoadingShape.Ring -> Daisy.Feedback.LoadingRing
  LoadingShape.Ball -> Daisy.Feedback.LoadingBall
  LoadingShape.Bars -> Daisy.Feedback.LoadingBars
  LoadingShape.Infinity -> Daisy.Feedback.LoadingInfinity
}

internal fun MaskShape.maskToken(): DaisyToken = when (this) {
  MaskShape.Squircle -> DaisyMasks.Squircle
  MaskShape.Heart -> DaisyMasks.Heart
  MaskShape.Hexagon -> DaisyMasks.Hexagon
  MaskShape.Hexagon2 -> DaisyMasks.Hexagon2
  MaskShape.Decagon -> DaisyMasks.Decagon
  MaskShape.Pentagon -> DaisyMasks.Pentagon
  MaskShape.Diamond -> DaisyMasks.Diamond
  MaskShape.Square -> DaisyMasks.Square
  MaskShape.Circle -> DaisyMasks.Circle
  MaskShape.Star -> DaisyMasks.Star
  MaskShape.Star2 -> DaisyMasks.Star2
  MaskShape.Triangle -> DaisyMasks.Triangle
  MaskShape.Triangle2 -> DaisyMasks.Triangle2
  MaskShape.Triangle3 -> DaisyMasks.Triangle3
  MaskShape.Triangle4 -> DaisyMasks.Triangle4
  MaskShape.Half1 -> DaisyMasks.Half1
  MaskShape.Half2 -> DaisyMasks.Half2
}

internal fun RatingShape.ratingMaskToken(): DaisyToken = when (this) {
  RatingShape.Star -> DaisyMasks.Star
  RatingShape.Star2 -> DaisyMasks.Star2
  RatingShape.Heart -> DaisyMasks.Heart
}

internal fun SwapVariant.swapToken(): DaisyToken? = when (this) {
  SwapVariant.Default -> null
  SwapVariant.Rotate -> Daisy.Display.SwapRotate
  SwapVariant.Flip -> Daisy.Display.SwapFlip
}
