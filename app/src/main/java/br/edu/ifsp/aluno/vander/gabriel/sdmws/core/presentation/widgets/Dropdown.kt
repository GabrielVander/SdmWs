package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun <T> Dropdown(
    label: String,
    items: List<T>,
    buildItemLabel: (item: T) -> String,
    onItemSelected: (item: T) -> Unit = {}
) {
    var expanded: Boolean by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { expanded = !expanded }) {
            Text(label)
            Icon(
                modifier = Modifier.rotate(if (expanded) 180f else 0f),
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },

            ) {
            items.forEach { item ->
                DropdownMenuItem(onClick = {
                    onItemSelected(item)
                    expanded = false
                }) {
                    Text(text = buildItemLabel(item))
                }
            }
        }
    }
}