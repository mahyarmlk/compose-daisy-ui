package composedaisyui

import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.Element

public interface DaisyToken {
  public val css: String
}

public data class DaisyClass(override val css: String) : DaisyToken

public fun cls(value: String): DaisyClass = DaisyClass(value)

public fun classesOf(vararg tokens: DaisyToken?, extra: String = ""): List<String> =
  buildList {
    tokens.filterNotNull().forEach { token ->
      token.css.splitToSequence(' ')
        .map(String::trim)
        .filter(String::isNotEmpty)
        .forEach(::add)
    }
    extra.splitToSequence(' ')
      .map(String::trim)
      .filter(String::isNotEmpty)
      .forEach(::add)
  }

public fun AttrsScope<Element>.tw(classes: String) {
  val names = classes.trim().split(Regex("\\s+")).filter(String::isNotBlank)
  if (names.isNotEmpty()) classes(names)
}

public fun AttrsScope<Element>.daisy(vararg tokens: DaisyToken?, extra: String = "") {
  val names = classesOf(*tokens, extra = extra)
  if (names.isNotEmpty()) classes(names)
}

