package composedaisyui

public enum class DaisyTheme(public val themeName: String) {
  Light("light"),
  Dark("dark"),
  Cupcake("cupcake"),
  Bumblebee("bumblebee"),
  Emerald("emerald"),
  Corporate("corporate"),
  Synthwave("synthwave"),
  Retro("retro"),
  Cyberpunk("cyberpunk"),
  Valentine("valentine"),
  Halloween("halloween"),
  Garden("garden"),
  Forest("forest"),
  Aqua("aqua"),
  Lofi("lofi"),
  Pastel("pastel"),
  Fantasy("fantasy"),
  Wireframe("wireframe"),
  Black("black"),
  Luxury("luxury"),
  Dracula("dracula"),
  Cmyk("cmyk"),
  Autumn("autumn"),
  Business("business"),
  Acid("acid"),
  Lemonade("lemonade"),
  Night("night"),
  Coffee("coffee"),
  Winter("winter"),
  Dim("dim"),
  Nord("nord"),
  Sunset("sunset"),
  Caramellatte("caramellatte"),
  Abyss("abyss"),
  Silk("silk");

  public companion object {
    public val allThemeNames: List<String> = entries.map { it.themeName }
    public fun fromThemeName(name: String): DaisyTheme? = entries.firstOrNull { it.themeName == name }
  }
}

public fun daisyThemeAttribute(theme: DaisyTheme): Pair<String, String> = "data-theme" to theme.themeName

