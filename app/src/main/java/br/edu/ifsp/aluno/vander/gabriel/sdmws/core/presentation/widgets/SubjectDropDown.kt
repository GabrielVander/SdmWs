package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject

@Composable
fun SubjectDropDown(
    subjects: List<Subject>?,
) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    var chosenSubject: String? by remember { mutableStateOf(null) }

    Button(onClick = {
        if (subjects != null) {
            expanded = !expanded
        }
    }) {
        Text(buildLabel(subjects, chosenSubject))
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = null,
        )
    }
    if (subjects != null) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            subjects.forEach { subject ->
                DropdownMenuItem(onClick = {
                    chosenSubject = subject.tag
                    expanded = false
                }) {
                    Text(text = subject.tag)
                }
            }
        }
    }
}

private fun buildLabel(subjects: List<Subject>?, chosenSubject: String?): String {
    if (subjects == null) {
        return "Loading..."
    }

    return chosenSubject ?: "Subjects"
}