package composedaisyui.datadisplay

import androidx.compose.runtime.Composable
import composedaisyui.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLTableElement

/**
 * A styled data table with optional zebra striping.
 *
 * @see <a href="https://daisyui.com/components/table/">daisyUI Table docs</a>
 *
 * @param headers Column header labels.
 * @param rows Data rows, each containing a list of cell strings.
 * @param zebra If true, applies alternating row colors.
 * @param attrs Additional HTML attributes.
 */
@Composable
public fun DataTable(
  headers: List<String>,
  rows: List<List<String>>,
  zebra: Boolean = false,
  attrs: AttrBuilderContext<HTMLTableElement>? = null
) {
  Table(attrs = {
    daisy(Daisy.Data.Table, if (zebra) Daisy.Data.TableZebra else null)
    attrs?.invoke(this)
  }) {
    Thead {
      Tr { headers.forEach { Th { Text(it) } } }
    }
    Tbody {
      rows.forEach { row ->
        Tr { row.forEach { Td { Text(it) } } }
      }
    }
  }
}
