package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.manager.MainViewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets.CourseDisplay
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets.SemesterDropDown
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets.SubjectDropDown

@Composable
fun MainPage(mainViewModel: MainViewModel = viewModel()) {
    val course: Course? by mainViewModel.course.observeAsState()
    val subjects: List<Subject>? by mainViewModel.subjects.observeAsState()

    mainViewModel.fetchCourse()

    Scaffold(modifier = Modifier.padding(15.dp)) {
        if (course == null) {
            Text(text = "Loading...")
        } else {
            Column(modifier = Modifier) {
                CourseDisplay(course!!)
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    SemesterDropDown(
                        course!!.amountOfSemesters,
                        onSemesterChosen = { semesterNumber ->
                            mainViewModel.fetchSubjectsForSemester(semesterNumber)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                if (subjects != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        SubjectDropDown(subjects!!)
                    }
                }
            }
        }
    }
}