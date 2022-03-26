package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.runtime.*
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject

@Composable
fun SubjectDropDown(
    subjects: List<Subject>,
) {
    var chosenSubject: String? by remember { mutableStateOf(null) }

    Dropdown(
        label = chosenSubject ?: "Subjects",
        items = subjects,
        buildItemLabel = { it.tag },
        onItemSelected = {
            chosenSubject = it.tag
        }
    )
}