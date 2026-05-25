package composedaisyui

import androidx.compose.runtime.Composable
import androidx.compose.web.attributes.SelectAttrsScope
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.builders.TextAreaAttrsScope
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Progress
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Table
import org.jetbrains.compose.web.dom.TagElement
import org.jetbrains.compose.web.dom.TextArea
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLLIElement
import org.w3c.dom.HTMLLabelElement
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.HTMLProgressElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.HTMLSpanElement
import org.w3c.dom.HTMLTableElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.HTMLUListElement

@Composable
public fun DaisyBox(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  Div(attrs = { daisy(*tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisySpan(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  Span(attrs = { daisy(*tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyButton(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLButtonElement>? = null,
  content: ContentBuilder<HTMLButtonElement>? = null
) {
  Button(attrs = { type(ButtonType.Button); daisy(Daisy.Button.Btn, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyAlert(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  DaisyBox(Daisy.Alert.Alert, *tokens, attrs = attrs, content = content)
}

@Composable
public fun DaisyBadge(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLSpanElement>? = null,
  content: ContentBuilder<HTMLSpanElement>? = null
) {
  DaisySpan(Daisy.Badge.Badge, *tokens, attrs = attrs, content = content)
}

@Composable
public fun DaisyCard(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  DaisyBox(Daisy.Card.Card, *tokens, attrs = attrs, content = content)
}

@Composable
public fun DaisyCollapse(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLDivElement>? = null,
  content: ContentBuilder<HTMLDivElement>? = null
) {
  DaisyBox(Daisy.Display.Collapse, *tokens, attrs = attrs, content = content)
}

@Composable
public fun DaisyInput(
  vararg tokens: DaisyToken?,
  type: InputType<String> = InputType.Text,
  attrs: (InputAttrsScope<String>.() -> Unit)? = null
) {
  Input(type = type, attrs = { daisy(Daisy.Form.Input, *tokens); attrs?.invoke(this) })
}

@Composable
public fun DaisyCheckbox(
  vararg tokens: DaisyToken?,
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  Input(type = InputType.Checkbox, attrs = { daisy(Daisy.Form.Checkbox, *tokens); attrs?.invoke(this) })
}

@Composable
public fun DaisyRadio(
  vararg tokens: DaisyToken?,
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  Input(type = InputType.Radio, attrs = { daisy(Daisy.Form.Radio, *tokens); attrs?.invoke(this) })
}

@Composable
public fun DaisyToggle(
  vararg tokens: DaisyToken?,
  attrs: (InputAttrsScope<Boolean>.() -> Unit)? = null
) {
  Input(type = InputType.Checkbox, attrs = { daisy(Daisy.Form.Toggle, *tokens); attrs?.invoke(this) })
}

@Composable
public fun DaisyRange(
  vararg tokens: DaisyToken?,
  attrs: (InputAttrsScope<Number?>.() -> Unit)? = null
) {
  Input(type = InputType.Range, attrs = { daisy(Daisy.Form.Range, *tokens); attrs?.invoke(this) })
}

@Composable
public fun DaisySelect(
  vararg tokens: DaisyToken?,
  attrs: (SelectAttrsScope.() -> Unit)? = null,
  content: ContentBuilder<HTMLSelectElement>? = null
) {
  Select(attrs = { daisy(Daisy.Form.Select, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyOption(
  value: String,
  attrs: AttrBuilderContext<HTMLOptionElement>? = null,
  content: ContentBuilder<HTMLOptionElement>? = null
) {
  Option(value = value, attrs = attrs, content = content)
}

@Composable
public fun DaisyTextarea(
  vararg tokens: DaisyToken?,
  value: String? = null,
  attrs: (TextAreaAttrsScope.() -> Unit)? = null
) {
  TextArea(value = value, attrs = { daisy(Daisy.Form.Textarea, *tokens); attrs?.invoke(this) })
}

@Composable
public fun DaisyLabel(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLLabelElement>? = null,
  content: ContentBuilder<HTMLLabelElement>? = null
) {
  Label(attrs = { daisy(Daisy.Form.Label, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyProgress(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLProgressElement>? = null,
  content: ContentBuilder<HTMLProgressElement>? = null
) {
  Progress(attrs = { daisy(Daisy.Feedback.Progress, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyMenu(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLUListElement>? = null,
  content: ContentBuilder<HTMLUListElement>? = null
) {
  Ul(attrs = { daisy(Daisy.Navigation.Menu, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyMenuItem(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLLIElement>? = null,
  content: ContentBuilder<HTMLLIElement>? = null
) {
  Li(attrs = { daisy(*tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisySteps(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLUListElement>? = null,
  content: ContentBuilder<HTMLUListElement>? = null
) {
  Ul(attrs = { daisy(Daisy.Navigation.Steps, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyStep(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLLIElement>? = null,
  content: ContentBuilder<HTMLLIElement>? = null
) {
  Li(attrs = { daisy(Daisy.Navigation.Step, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyTable(
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<HTMLTableElement>? = null,
  content: ContentBuilder<HTMLTableElement>? = null
) {
  Table(attrs = { daisy(Daisy.Data.Table, *tokens); attrs?.invoke(this) }, content = content)
}

@Composable
public fun DaisyGeneric(
  tagName: String,
  vararg tokens: DaisyToken?,
  attrs: AttrBuilderContext<Element>? = null,
  content: ContentBuilder<Element>? = null
) {
  TagElement(
    elementBuilder = org.jetbrains.compose.web.dom.ElementBuilder.createBuilder(tagName),
    applyAttrs = { daisy(*tokens); attrs?.invoke(this) },
    content = content
  )
}
