# compose-daisy-ui

A Compose-first component library for Kotlin/JS Compose HTML, powered by daisyUI 5.

[![CI](https://github.com/mahyarmlk/compose-daisy-ui/actions/workflows/ci.yml/badge.svg)](https://github.com/mahyarmlk/compose-daisy-ui/actions/workflows/ci.yml)

- `:compose-daisyui-core` provides daisyUI class tokens, theme names, Tailwind/daisyUI CSS config helpers, and lower-level Compose HTML wrappers.
- `:compose-daisyui` provides the high-level Compose-style component layer on top of core.
- `buildSrc` provides `io.github.mahyarmlk.webpack`, a small Gradle plugin that generates the Kotlin/JS Webpack bridge for Tailwind CSS 4 and daisyUI.

## Status

This project is pre-1.0. APIs are intended to be small, typed, and Compose-like,
but they may still evolve as component coverage matures.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.mahyarmlk/compose-daisyui-js)](https://central.sonatype.com/artifact/io.github.mahyarmlk/compose-daisyui-js)

Demo: [mahyarmlk.github.io/compose-daisy-ui](https://mahyarmlk.github.io/compose-daisy-ui)

## Modules

Available on Maven Central as `io.github.mahyarmlk:compose-daisyui-js` and `io.github.mahyarmlk:compose-daisyui-core-js`.

Use `compose-daisyui-js` for app work. It exports `compose-daisyui-core-js` transitively, so token escape hatches remain available:

```kotlin
// build.gradle.kts
repositories {
  mavenCentral()
}

dependencies {
  implementation("io.github.mahyarmlk:compose-daisyui-js:0.1.0")
}
```

Use `compose-daisyui-core-js` when you only want tokens, themes, CSS helpers, and thin HTML wrappers:

```kotlin
dependencies {
  implementation("io.github.mahyarmlk:compose-daisyui-core-js:0.1.0")
}
```

## Component Usage

The primary API is now a component layer with Compose-like state hoisting, typed sizes/colors/variants, slot parameters, and `attrs` escape hatches:

```kotlin
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import composedaisyui.Button
import composedaisyui.Card
import composedaisyui.Scaffold
import composedaisyui.TextField
import composedaisyui.TopAppBar
import composedaisyui.UiColor

var email by mutableStateOf("")

Scaffold(
  topBar = { TopAppBar(title = "Settings") }
) {
  Card(
    title = "Account",
    actions = {
      Button("Save", color = UiColor.Primary)
    }
  ) {
    TextField(
      value = email,
      onValueChange = { email = it },
      label = "Email",
      placeholder = "you@example.com",
      color = UiColor.Primary
    )
  }
}
```

Current component families include:

- App structure: `Scaffold`, `TopAppBar`, `Surface`, `Hero`, `Footer`, `Navbar`
- Actions: `Button`, `IconButton`, `Fab`, `SpeedDial`
- Data display: `Badge`, `Card`, `UiList`, `ListItem`, `Stats`, `DataTable`, `Timeline`, `Kbd`
- Feedback: `Alert`, `LinearProgress`, `Progress`, `RadialProgress`, `Loading`, `Skeleton`, `Status`, `Toast`, `Tooltip`
- Forms: `TextField`, `TextAreaField`, `SelectField`, `FileInputField`, `Checkbox`, `Switch`, `RadioButton`, `Slider`, `Rating`, `Filter`, `FilterReset`, `FloatingLabel`, `Fieldset`, `LabelText`, `ThemeController`, `ValidatorHint`
- Layout: `Divider`, `Drawer`, `Indicator`, `Join`, `JoinItem`, `Stack`
- Navigation: `Breadcrumbs`, `Dock`, `Dropdown`, `Menu`, `NavigationRail`, `Pagination`, `Steps`, `Tabs`
- Display and mockups: `Accordion`, `Avatar`, `AvatarGroup`, `Calendar`, `Carousel`, `CarouselItem`, `Chat`, `Collapse`, `Countdown`, `Diff`, `Hover3d`, `HoverGallery`, `Link`, `Mask`, `Modal`, `MockupBrowser`, `MockupCode`, `MockupPhone`, `MockupWindow`, `Swap`, `TextRotate`

## Token Usage

The token layer still exists for exact daisyUI control and for components that do not have a high-level wrapper yet:

```kotlin
import composedaisyui.Daisy
import composedaisyui.DaisyButton
import composedaisyui.daisy
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

Div({ daisy(extra = "p-6 bg-base-100 text-base-content") }) {
  DaisyButton(Daisy.Button.Primary, Daisy.Button.Wide) {
    Text("Save")
  }
}
```

Use tokens directly when a component-level abstraction is not needed:

```kotlin
Div({ daisy(Daisy.Display.Modal, Daisy.Display.ModalOpen) }) {
  Div({ daisy(Daisy.Display.ModalBox) }) {
    Text("Dialog content")
  }
}
```

Use modifier factories for classes that share daisyUI naming rules:

```kotlin
DaisyButton(color("btn", DaisyColor.Success), size("btn", DaisySize.Lg)) {
  Text("Done")
}
```

## CSS

daisyUI 5 runs as a Tailwind CSS 4 plugin. App modules include:

```css
@import "tailwindcss";
@plugin "daisyui";
```

App modules do not need to carry a handwritten `webpack.config.d` file. Apply the helper plugin:

```kotlin
plugins {
  id("io.github.mahyarmlk.webpack")
}
```

The plugin generates the Webpack bridge that resolves Tailwind plugins from Kotlin/JS' generated `node_modules`, keeping the setup compatible with Gradle-managed npm dependencies while hiding the JavaScript plumbing.

## Development

```bash
./gradlew :app:jsBrowserDevelopmentRun   # dev server (port 3000)
./gradlew build                          # full build
./gradlew publishToMavenLocal            # local maven for testing
./gradlew publishToMavenCentral          # publish to Maven Central
```

The demo app runs on `http://localhost:3000/`.

## Publishing

This project publishes to Maven Central via the [Sonatype Central Portal](https://central.sonatype.com).

### Prerequisites

- A verified namespace on Sonatype Central (`io.github.mahyarmlk`)
- A GPG key pair with the public key uploaded to `keyserver.ubuntu.com` and `keys.openpgp.org`
- A Sonatype user token for authentication

### Local credentials

Create `~/.gradle/gradle.properties`:

```properties
signingInMemoryKeyPassword=YOUR_GPG_PASSPHRASE
mavenCentralUsername=YOUR_SONATYPE_TOKEN_USERNAME
mavenCentralPassword=YOUR_SONATYPE_TOKEN_PASSWORD
```

And place your armored private key at `~/.gradle/signing-key.asc`.

### Release via GitHub Actions

The `.github/workflows/release.yml` workflow triggers on version tags. It publishes to Maven Central and then creates the matching GitHub Release automatically. Add these secrets to your repo:

| Secret | Value |
|---|---|
| `SIGNING_KEY` | Full armored PGP private key |
| `SIGNING_PASSWORD` | GPG key passphrase |
| `MAVEN_CENTRAL_USERNAME` | Sonatype token username |
| `MAVEN_CENTRAL_PASSWORD` | Sonatype token password |

Then push a version tag:

```bash
git tag v0.1.1 && git push origin v0.1.1
```

The workflow passes the tag version into Gradle as `VERSION_NAME`, so local development can stay on the default version while release tags publish the intended artifact version.

If a deployment is only in **Validated** state on Sonatype Central and should not be published, drop it from [central.sonatype.com/publishing/deployments](https://central.sonatype.com/publishing/deployments) and tag a corrected version later.

After validation on [central.sonatype.com/publishing/deployments](https://central.sonatype.com/publishing/deployments), click **Publish** to release the artifacts (propagation takes 15-30 minutes).

## Coverage

The library exposes tokens for daisyUI components, parts, styles, colors, sizes, placements, directions, layout helpers, theme controller, validator, masks, mockups, and all built-in themes listed in daisyUI 5:

`light`, `dark`, `cupcake`, `bumblebee`, `emerald`, `corporate`, `synthwave`, `retro`, `cyberpunk`, `valentine`, `halloween`, `garden`, `forest`, `aqua`, `lofi`, `pastel`, `fantasy`, `wireframe`, `black`, `luxury`, `dracula`, `cmyk`, `autumn`, `business`, `acid`, `lemonade`, `night`, `coffee`, `winter`, `dim`, `nord`, `sunset`, `caramellatte`, `abyss`, `silk`.

Some tokens exist specifically as public escape hatches and may not be used by
the high-level component layer internally. That is intentional: consumers can
compose exact daisyUI markup while the typed components continue to grow.

## License

Apache-2.0. See [LICENSE](LICENSE).
