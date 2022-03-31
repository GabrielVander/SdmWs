package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course

@Composable
fun CourseDisplay(course: Course) {
    Column(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.medium,
            )
            .padding(5.dp)
    ) {
        Title()
        Name(course.name)
        Tag(course.tag)
        Workload(course.workloadInHours)
        Semesters(course.amountOfSemesters)
    }
}

@Composable
private fun Title() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = "Course", fontSize = 21.sp)
    }
}

@Composable
private fun Name(name: String) {
    Row {
        Text(text = "Name: ")
        Text(text = name)
    }
}

@Composable
private fun Tag(tag: String) {
    Row {
        Text(text = "Tag: ")
        Text(text = tag)
    }
}

@Composable
private fun Workload(workloadInHours: Int) {
    Row {
        Text(text = "Workload: ")
        Text(text = workloadInHours.toString() + "h")
    }
}

@Composable
private fun Semesters(amountOfSemesters: Int) {
    Row {
        Text(text = "Amount of semesters: ")
        Text(text = amountOfSemesters.toString())
    }
}