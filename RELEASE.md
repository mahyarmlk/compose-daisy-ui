# Release

## Local Verification

```bash
./gradlew build
./gradlew publishToMavenLocal
```

## Maven Central

This project is configured with Gradle `maven-publish` and optional in-memory
PGP signing. Before publishing to a remote repository, provide credentials and
signing material through Gradle properties or CI secrets.

Expected signing properties:

```properties
signingInMemoryKey=...
signingInMemoryKeyPassword=...
```

The current repository config publishes to a local staging repository at
`build/staging-deploy` for inspection. Add the Maven Central or Central Portal
repository endpoint and credentials in CI when the namespace is approved.

## Cloudflare Pages

The demo site is a static Kotlin/JS distribution:

```bash
./gradlew :app:jsBrowserDistribution
npx wrangler pages deploy app/build/dist/js/productionExecutable --project-name compose-daisy-ui
```

## GitHub

Initialize and publish the repository after authenticating `gh`:

```bash
git init
git add .
git commit -m "Initial public release"
gh repo create mahyarmlk/compose-daisy-ui --public --source=. --remote=origin --push
```
