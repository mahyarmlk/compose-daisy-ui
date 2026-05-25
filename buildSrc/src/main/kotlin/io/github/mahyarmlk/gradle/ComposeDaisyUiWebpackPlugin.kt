package io.github.mahyarmlk.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeDaisyUiWebpackPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    val configDir = project.layout.projectDirectory.dir("webpack.config.d").asFile
    val configFile = configDir.resolve("compose-daisy-ui.generated.js")

    project.tasks.register("generateComposeDaisyUiWebpackConfig") {
      group = "compose-daisy-ui"
      description = "Generates the Webpack bridge for Tailwind CSS 4 and daisyUI in Kotlin/JS projects."
      outputs.file(configFile)
      doLast {
        configDir.mkdirs()
        configFile.writeText(generatedWebpackConfig)
      }
    }

    project.tasks.matching { task ->
      task.name != "generateComposeDaisyUiWebpackConfig" &&
        (task.name.contains("Webpack", ignoreCase = true) ||
          task.name.endsWith("DevelopmentRun") ||
          task.name.endsWith("ProductionRun"))
    }.configureEach {
      dependsOn("generateComposeDaisyUiWebpackConfig")
    }

    configDir.mkdirs()
    if (!configFile.exists()) {
      configFile.writeText(generatedWebpackConfig)
    }
  }

  private companion object {
    private val generatedWebpackConfig = """
      const path = require('path');
      const mainCssFile = 'styles.css';
      const entryPath = path.resolve(__dirname, 'kotlin', mainCssFile);
      const jsBuildDirectory = path.resolve(__dirname, '../..');
      const nodeModulesDirectory = path.resolve(jsBuildDirectory, 'node_modules');

      const resolveTailwindPluginsFromKotlinJsNodeModules = {
        postcssPlugin: 'resolve-tailwind-plugins-from-kotlin-js-node-modules',
        Once(root) {
          root.walkAtRules('plugin', (atRule) => {
            const pluginName = atRule.params.trim().slice(1, -1);
            if (!pluginName || pluginName.startsWith('.') || path.isAbsolute(pluginName)) return;
            const pluginPackageJson = require.resolve(`${'$'}{pluginName}/package.json`, { paths: [nodeModulesDirectory] });
            atRule.params = JSON.stringify(path.dirname(pluginPackageJson));
          });
        }
      };

      ((config) => {
        if (!config.entry.main.includes(entryPath)) {
          config.entry.main.push(entryPath);
        }
        config.module.rules.push({
          test: /\.css${'$'}/,
          use: [
            { loader: 'style-loader' },
            { loader: 'css-loader' },
            {
              loader: 'postcss-loader',
              options: {
                postcssOptions: {
                  plugins: [
                    require('postcss-import')({ path: [nodeModulesDirectory] }),
                    resolveTailwindPluginsFromKotlinJsNodeModules,
                    require('@tailwindcss/postcss')({ base: jsBuildDirectory })
                  ]
                }
              }
            }
          ]
        });
      })(config);
    """.trimIndent()
  }
}
