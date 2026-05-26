package sections

import androidx.compose.runtime.Composable
import composedaisyui.tw
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
public fun HeroSection() {
  Div({
    tw(
      "relative isolate min-h-[calc(100svh-8rem)] overflow-hidden " +
        "bg-base-100 text-base-content"
    )
  }) {
    HeroBackdrop()

    Div({
      tw(
        "relative z-10 grid min-h-[calc(100svh-8rem)] w-full max-w-7xl mx-auto " +
          "grid-cols-1 xl:grid-cols-[minmax(0,1.02fr)_minmax(430px,0.98fr)] " +
          "items-center gap-6 px-5 py-8 sm:px-8 sm:py-10 lg:px-10"
      )
    }) {
      HeroCopy()
      ProductPreview()
    }
  }
}

@Composable
private fun HeroBackdrop() {
  Div({
    tw(
      "absolute inset-0 -z-10 " +
        "bg-[linear-gradient(120deg,var(--color-base-100)_0%,var(--color-base-100)_48%,var(--color-base-200)_48%,var(--color-base-200)_100%)]"
    )
  }) {}
  Div({
    tw(
      "absolute inset-0 -z-10 opacity-50 " +
        "bg-[linear-gradient(var(--color-base-content)/0.055_1px,transparent_1px),linear-gradient(90deg,var(--color-base-content)/0.055_1px,transparent_1px)] " +
        "bg-[size:44px_44px]"
    )
  }) {}
  Div({
    tw(
      "absolute bottom-0 left-0 right-0 -z-10 h-32 " +
        "bg-gradient-to-t from-primary/10 to-transparent"
    )
  }) {}
}

@Composable
private fun HeroCopy() {
  Div({
    tw(
      "flex min-h-0 flex-col items-start justify-center gap-5 " +
        "lg:max-w-2xl"
    )
  }) {
    H1({
      tw(
        "max-w-4xl text-5xl font-black leading-[0.92] " +
          "sm:text-6xl lg:text-[4.5rem] xl:text-7xl " +
          "max-[900px]:text-5xl max-[720px]:text-4xl"
      )
    }) {
      Text("Compose daisyUI")
      Span({ tw("block text-primary") }) {
        Text("for Kotlin/JS")
      }
    }

    P({
      tw(
        "max-w-2xl text-base leading-7 text-base-content/80 " +
          "sm:text-lg lg:text-xl lg:leading-8"
      )
    }) {
      Text(
        "Build Compose HTML interfaces with typed Kotlin APIs, " +
          "daisyUI 5 tokens, Tailwind CSS 4 utilities, and theme-ready components."
      )
    }

    CtaButtons()
    InstallStrip()
    ProofRow()
  }
}

@Composable
private fun CtaButtons() {
  Div({ tw("flex flex-wrap items-center gap-3") }) {
    A(attrs = {
      href("#docs")
      tw("btn btn-primary btn-lg")
    }) {
      Text("Get Started")
    }
    A(attrs = {
      href("#components")
      tw("btn btn-outline btn-neutral btn-lg border-base-content/30 text-base-content hover:bg-base-content hover:text-base-100")
    }) {
      Text("View Components")
    }
  }
}

@Composable
private fun InstallStrip() {
  Div({
    tw(
      "w-full max-w-2xl overflow-hidden rounded-box border border-base-content/10 " +
        "bg-neutral text-neutral-content shadow-xl"
    )
  }) {
    Div({ tw("flex items-center gap-2 border-b border-neutral-content/10 px-5 py-3") }) {
      Div({ tw("h-2.5 w-2.5 rounded-full bg-error") }) {}
      Div({ tw("h-2.5 w-2.5 rounded-full bg-warning") }) {}
      Div({ tw("h-2.5 w-2.5 rounded-full bg-success") }) {}
    }
    Div({ tw("overflow-x-auto py-3") }) {
      InstallCodeLine("1") {
        Span({ tw("text-info") }) { Text("implementation") }
        Text("(")
        Span({ tw("text-success") }) { Text("\"io.github.mahyarmlk:compose-daisyui-js:0.1.1\"") }
        Text(")")
      }
      InstallCodeLine("2") {
        Span({ tw("text-accent") }) { Text("@import") }
        Text(" ")
        Span({ tw("text-success") }) { Text("\"tailwindcss\"") }
        Text(";")
      }
      InstallCodeLine("3") {
        Span({ tw("text-accent") }) { Text("@plugin") }
        Text(" ")
        Span({ tw("text-success") }) { Text("\"daisyui\"") }
        Text(";")
      }
    }
  }
}

@Composable
private fun InstallCodeLine(index: String, content: @Composable () -> Unit) {
  Div({
    tw(
      "grid min-w-max grid-cols-[2.75rem_minmax(32rem,1fr)] gap-4 " +
        "px-5 py-1 font-mono text-sm leading-6"
    )
  }) {
    Div({ tw("select-none text-right text-neutral-content/40") }) { Text(index) }
    Div({ tw("whitespace-pre text-neutral-content") }) { content() }
  }
}

@Composable
private fun ProofRow() {
  Div({
    tw(
      "grid w-full max-w-2xl grid-cols-3 divide-x divide-base-content/10 " +
        "rounded-box border border-base-content/10 bg-base-100/80 shadow-sm backdrop-blur"
    )
  }) {
    ProofMetric("80+", "components")
    ProofMetric("35+", "themes")
    ProofMetric("0 css", "required")
  }
}

@Composable
private fun ProofMetric(value: String, label: String) {
  Div({ tw("px-4 py-3") }) {
    Div({ tw("text-xl font-black text-base-content sm:text-2xl") }) { Text(value) }
    Div({ tw("text-xs font-semibold uppercase text-base-content/70") }) { Text(label) }
  }
}

@Composable
private fun ProductPreview() {
  Div({
    tw(
      "hidden xl:flex min-h-0 items-center justify-center"
    )
  }) {
    Div({
      tw(
        "mockup-browser w-full max-w-xl border border-base-content/10 " +
          "bg-base-300 shadow-2xl"
      )
    }) {
      Div({ tw("mockup-browser-toolbar") }) {
        Div({ tw("input border-base-content/10 bg-base-100 text-base-content/75") }) {
          Text("compose-daisy-ui.dev/components")
        }
      }
      Div({ tw("bg-base-100 p-6") }) {
        PreviewToolbar()
        PreviewShowcase()
        PreviewLibraryApi()
      }
    }
  }
}

@Composable
private fun PreviewToolbar() {
  Div({ tw("mb-5 flex items-center justify-between gap-4") }) {
    Div {
      Div({ tw("text-sm font-bold text-base-content") }) { Text("Component preview") }
      Div({ tw("text-xs text-base-content/70") }) { Text("Typed Compose wrappers over daisyUI classes") }
    }
    Div({ tw("join") }) {
      Div({ tw("btn btn-xs join-item btn-primary") }) { Text("Light") }
      Div({ tw("btn btn-xs join-item") }) { Text("Dark") }
      Div({ tw("btn btn-xs join-item") }) { Text("Retro") }
    }
  }
}

@Composable
private fun PreviewShowcase() {
  Div({ tw("grid grid-cols-[1fr_0.8fr] gap-4") }) {
    Div({ tw("rounded-box border border-base-content/10 bg-base-200 p-4") }) {
      Div({ tw("mb-4 flex items-center gap-3") }) {
        Div({ tw("avatar placeholder") }) {
          Div({ tw("w-12 rounded-full bg-primary text-primary-content") }) {
            Span({ tw("text-sm font-bold") }) { Text("CD") }
          }
        }
        Div {
          Div({ tw("font-bold") }) { Text("Themeable card") }
          Div({ tw("text-sm text-base-content/70") }) { Text("Semantic color tokens") }
        }
      }
      Div({ tw("flex flex-wrap gap-2") }) {
        Div({ tw("badge badge-primary badge-soft") }) { Text("Primary") }
        Div({ tw("badge badge-secondary badge-soft") }) { Text("Secondary") }
        Div({ tw("badge badge-accent badge-soft") }) { Text("Accent") }
      }
      Div({ tw("mt-5 flex gap-2") }) {
        Div({ tw("btn btn-sm btn-primary") }) { Text("Save") }
        Div({ tw("btn btn-sm btn-ghost") }) { Text("Cancel") }
      }
    }

    Div({ tw("space-y-3") }) {
      PreviewStat("API", "Kotlin-first")
      PreviewStat("CSS", "daisyUI 5")
      PreviewStat("Build", "Tailwind 4")
    }
  }
}

@Composable
private fun PreviewStat(label: String, value: String) {
  Div({ tw("rounded-box border border-base-content/10 bg-base-100 p-3 shadow-sm") }) {
    Div({ tw("text-xs font-semibold uppercase text-base-content/70") }) { Text(label) }
    Div({ tw("text-sm font-bold text-base-content") }) { Text(value) }
  }
}

@Composable
private fun PreviewLibraryApi() {
  Div({
    tw(
      "mt-4 rounded-box bg-neutral p-4 font-mono text-xs leading-6 text-neutral-content"
    )
  }) {
    Div { Text("Button(") }
    Div({ tw("pl-4 text-primary") }) { Text("text = \"Launch\",") }
    Div({ tw("pl-4 text-secondary") }) { Text("color = UiColor.Primary,") }
    Div({ tw("pl-4 text-accent") }) { Text("variant = UiVariant.Soft") }
    Div { Text(")") }
  }
}
