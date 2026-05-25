package composedaisyui.form

import composedaisyui.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLInputElement

/**
 * Applies the daisyUI validator class to an input element, enabling validation styling.
 *
 * @see <a href="https://daisyui.com/components/validator/">daisyUI Validator docs</a>
 */
public fun AttrsScope<HTMLInputElement>.validator() {
  daisy(Daisy.Form.Validator)
}
