package composedaisyui.app

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Main
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement

/**
 * A top-level application layout with optional top bar and bottom bar.
 *
 * @see <a href="https://daisyui.com/components/">daisyUI docs</a>
 *
 * @param topBar Optional composable rendered in the header area.
 * @param bottomBar Optional composable rendered in the footer area.
 * @param attrs Additional HTML attributes for the root `<div>`.
 * @param contentAttrs Additional HTML attributes for the `<main>` content area.
 * @param content Main content composable.
 */
@Composable
public fun Scaffold(
  topBar: (@Composable () -> Unit)? = null,
  bottomBar: (@Composable () -> Unit)? = null,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  contentAttrs: AttrBuilderContext<HTMLElement>? = null,
  content: ContentBuilder<HTMLElement>
) {
  Div(attrs = {
    daisy(extra = "min-h-screen bg-base-100 text-base-content")
    attrs?.invoke(this)
  }) {
    topBar?.invoke()
    Main(attrs = {
      daisy(extra = "mx-auto w-full max-w-7xl px-4 py-6 sm:px-6 lg:px-8")
      contentAttrs?.invoke(this)
    }, content = content)
    bottomBar?.invoke()
  }
}
