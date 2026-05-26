# Release

This project publishes Maven artifacts through GitHub Actions and creates the
matching GitHub Release automatically from version tags.

## Local Verification

```bash
./gradlew build
./gradlew publishToMavenLocal
```

The local default version is the latest intended release. Release builds pass the tag version into
Gradle as `composeDaisyUiVersion`, for example `-PcomposeDaisyUiVersion=0.1.1`.

## Maven Central

This project is configured with `com.vanniktech.maven.publish` for the Sonatype
Central Portal. Before publishing, provide credentials and signing material
through GitHub Actions secrets.

Expected secrets:

| Secret | Value |
|---|---|
| `SIGNING_KEY` | Full armored PGP private key |
| `SIGNING_PASSWORD` | GPG key passphrase |
| `MAVEN_CENTRAL_USERNAME` | Sonatype token username |
| `MAVEN_CENTRAL_PASSWORD` | Sonatype token password |

Push a version tag to start the release:

```bash
git tag v0.1.1
git push origin v0.1.1
```

The workflow uploads artifacts to Maven Central and then creates the matching
GitHub Release with generated notes.

If a Sonatype deployment is only in **Validated** state and should not ship,
drop it in the Central Portal deployments page. Maven Central versions are
immutable after publishing, so publish a corrected new version instead of trying
to replace an already-published one.

## GitHub Pages

The demo site is a static Kotlin/JS distribution:

```bash
./gradlew :app:jsBrowserDistribution
```

The `.github/workflows/pages.yml` workflow deploys it to GitHub Pages on pushes
to `main`.
