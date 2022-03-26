package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.runtime.*

@Composable
fun SemesterDropDown(
    amountOfSemesters: Int,
    onSemesterChosen: (chosenSemester: Int) -> Unit = {}
) {
    var chosenSemester: String? by remember { mutableStateOf(null) }
    val semesters: List<Int> = (1..amountOfSemesters).toList()

    Dropdown(
        label = chosenSemester ?: "Semesters",
        items = semesters,
        buildItemLabel = { it.toString() },
        onItemSelected = { semesterNumber ->
            chosenSemester = semesterNumber.toString()
            onSemesterChosen(semesterNumber)
        }
    )
}