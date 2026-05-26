# AGENTS.md

## Architecture

Three-module Gradle project (Kotlin/JS, Compose HTML, daisyUI 5, Tailwind CSS 4):

- **`:compose-daisyui-core`** — Foundation layer: `DaisyToken` type, `Daisy` object with daisyUI CSS class tokens, theme enums (`DaisyTheme`), `DaisyModifiers`, and thin composable wrappers (`DaisyBox`, `DaisyButton`, `DaisyCard`, etc.).
- **`:compose-daisyui`** — High-level component library: Compose-style components (Button, Card, TextField, etc.) using enum models (`UiColor`, `UiSize`, `UiVariant`, etc.) mapped to core tokens.
- **`:app`** — Demo app. Dev server on port 3000, auto-opens browser.

## Commands

```
./gradlew :app:jsBrowserDevelopmentRun   # dev server (port 3000)
./gradlew build                          # full build
./gradlew :compose-daisyui:assemble      # build component lib only
```

There are no dedicated lint, typecheck, or test commands. Kotlin compilation serves as type checking. There are no test sources yet.

## Component patterns

Every daisyUI component wraps a base HTML element via Compose HTML APIs (`Div`, `Button`, `Input`, etc.).

### Core token structure (`:compose-daisyui-core`)

- `Daisy.ComponentName.TokenName` in `Daisy.kt` — each token is a `DaisyToken` created via `cls("daisyui-class")`.
- `DaisyComponents.kt` — thin composable wrappers that apply the base token automatically (e.g. `DaisyButton` always adds `Daisy.Button.Btn`).
- `DaisyTokens.kt` — `daisy()` and `tw()` extension functions for `AttrsScope<Element>`, plus `classesOf()` for building class lists.

### High-level component pattern (`:compose-daisyui`)

Each component gets its own file under a category directory:
`src/jsMain/kotlin/composedaisyui/{actions,datadisplay,feedback,form,layout,misc,mockup,navigation}/`

A component composable follows this pattern:
```kotlin
@Composable
public fun Button(
  text: String? = null,
  color: UiColor? = null,
  size: UiSize? = null,
  variant: UiVariant = UiVariant.Solid,
  // ...typed params
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ContentBuilder<HTMLButtonElement>? = null
) {
  Button(attrs = {
    daisy(
      Daisy.Button.Btn,
      color?.let { color("btn", it.toDaisyColor()) },
      size?.let { size("btn", it.toDaisySize()) },
      variant.buttonToken(),
      // ...
    )
    attrs?.invoke(this)
  }) { /* slots */ }
}
```

- Enum-to-token mapping lives in `internal/ComponentTokens.kt` (e.g. `UiVariant.buttonToken()`).
- Shared enums (`UiColor`, `UiSize`, `UiVariant`, etc.) and data classes (`BreadcrumbItem`, `SelectOption`, etc.) live in `DaisyUiModels.kt`.
- `color()`, `size()`, `direction()`, `placement()` helper functions are in `DaisyModifiers.kt` (core module).

### Variant convention

The `Default` / `Solid` / `Plain` variant always maps to `null` (no extra token), relying on the base daisyUI class for the default style.

## daisyUI CSS reference

Full daisyUI 5 component class names and syntax are in `.agents/skills/daisyui/SKILL.md`. Consult this when adding new components or tokens.

## Webpack / CSS build

- `buildSrc/` contains `ComposeDaisyUiWebpackPlugin` — auto-generates `webpack.config.d/compose-daisy-ui.generated.js` (gitignored) with PostCSS config for Tailwind CSS 4 and daisyUI 5.
- CSS entrypoint: `app/src/jsMain/resources/styles.css` (`@import "tailwindcss"; @plugin "daisyui";`).
- npm dependencies declared via `implementation(npm(...))` in `app/build.gradle.kts`. Uses npm (not Yarn): `kotlin.js.yarn=false` in `gradle.properties`.

## Kotlin / Gradle specifics

- Kotlin 2.3.20, Compose plugin 1.11.0, Gradle 9.3.1
- Group: `io.github.mahyarmlk`, version `0.1.0`
- `:compose-daisyui` depends on `:compose-daisyui-core` via `api(project(...))`
- `:app` depends on `:compose-daisyui` via `implementation(project(...))`
- Source sets: `jsMain` only (no `commonMain`, no `jsTest`)
