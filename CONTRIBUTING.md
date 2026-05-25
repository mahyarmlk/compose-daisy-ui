# Contributing

Thanks for helping improve Compose daisyUI.

## Development

Use the Gradle wrapper from the repository root:

```bash
./gradlew :app:jsBrowserDevelopmentRun
./gradlew build
./gradlew :compose-daisyui:checkKotlinAbi
```

There are currently no dedicated test sources. Kotlin compilation is the
primary type check until the project adds component tests.

## Guidelines

- Keep high-level components in `:compose-daisyui`.
- Keep daisyUI class tokens and thin wrappers in `:compose-daisyui-core`.
- Prefer typed enum parameters for public component APIs.
- Keep `Default`, `Solid`, and `Plain` variants mapped to no extra daisyUI
  class unless the upstream daisyUI default requires otherwise.
- Use Tailwind CSS utilities and daisyUI class names instead of custom CSS.

## Publishing

Release builds are configured with Gradle `maven-publish` and optional in-memory
PGP signing. Publish locally first:

```bash
./gradlew publishToMavenLocal
```

Real Maven Central publishing requires repository credentials and signing keys
provided through Gradle properties or CI secrets.
