package composedaisyui

public data class DaisyUiConfig(
  val themes: List<DaisyTheme> = listOf(DaisyTheme.Light, DaisyTheme.Dark),
  val defaultTheme: DaisyTheme = DaisyTheme.Light,
  val prefersDarkTheme: DaisyTheme = DaisyTheme.Dark,
  val root: String = ":root",
  val include: List<String> = emptyList(),
  val exclude: List<String> = emptyList(),
  val prefix: String = "",
  val logs: Boolean = true
) {
  public fun css(): String {
    val themeLine = themes.joinToString(", ") { theme ->
      buildString {
        append(theme.themeName)
        if (theme == defaultTheme) append(" --default")
        if (theme == prefersDarkTheme) append(" --prefersdark")
      }
    }
    return buildString {
      appendLine("@import \"tailwindcss\";")
      appendLine("@plugin \"daisyui\" {")
      appendLine("  themes: $themeLine;")
      appendLine("  root: \"$root\";")
      appendLine("  include: ${include.joinToString(", ")};")
      appendLine("  exclude: ${exclude.joinToString(", ")};")
      appendLine("  prefix: $prefix;")
      appendLine("  logs: $logs;")
      appendLine("}")
    }
  }
}

public fun defaultDaisyCss(): String = DaisyUiConfig().css()
public fun allDaisyThemesCss(defaultTheme: DaisyTheme = DaisyTheme.Light): String =
  DaisyUiConfig(
    themes = DaisyTheme.entries,
    defaultTheme = defaultTheme,
    prefersDarkTheme = DaisyTheme.Dark
  ).css()

