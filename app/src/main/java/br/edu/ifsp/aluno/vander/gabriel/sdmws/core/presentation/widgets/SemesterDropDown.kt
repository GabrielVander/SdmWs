package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*

@Composable
fun SemesterDropDown(
    amountOfSemesters: Int,
    onSemesterChosen: (chosenSemester: Int) -> Unit = {}
) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    var chosenSemester: String? by remember { mutableStateOf(null) }
    val semesters: List<Int> = (1..amountOfSemesters).toList()

    Button(onClick = { expanded = !expanded }) {
        Text(chosenSemester ?: "Semesters")
        Icon(
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = null,
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
    ) {
        semesters.forEach { semesterNumber ->
            DropdownMenuItem(onClick = {
                chosenSemester = semesterNumber.toString()
                onSemesterChosen(semesterNumber)
                expanded = false
            }) {
                Text(text = semesterNumber.toString())
            }
        }
    }
}