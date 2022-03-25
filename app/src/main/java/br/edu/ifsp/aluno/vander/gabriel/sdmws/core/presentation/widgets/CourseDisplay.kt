package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course

@Composable
fun CourseDisplay(course: Course) {
    Column(modifier = Modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "Course")
        }
        Row {
            Text(text = "Name: ")
            Text(text = course.name)
        }
        Row {
            Text(text = "Tag: ")
            Text(text = course.tag)
        }
        Row {
            Text(text = "Workload (in hours): ")
            Text(text = course.workloadInHours.toString())
        }
        Row {
            Text(text = "Amount of semesters: ")
            Text(text = course.amountOfSemesters.toString())
        }
    }
}