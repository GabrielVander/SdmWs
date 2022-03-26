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
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets.SubjectDisplay
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets.SubjectDropDown

@Composable
fun MainPage(mainViewModel: MainViewModel = viewModel()) {
    val course: Course? by mainViewModel.course.observeAsState()
    val subjects: List<Subject>? by mainViewModel.subjects.observeAsState()
    val chosenSubject: Subject? by mainViewModel.chosenSubject.observeAsState()

    mainViewModel.fetchCourse()

    Scaffold(modifier = Modifier.padding(15.dp)) {
        RenderContent(course, mainViewModel, subjects, chosenSubject)
    }
}

@Composable
private fun RenderContent(
    course: Course?,
    mainViewModel: MainViewModel,
    subjects: List<Subject>?,
    chosenSubject: Subject?
) {
    if (course == null) {
        Text(text = "Loading...")
    } else {
        Column(modifier = Modifier) {
            CourseDisplay(course)
            RenderSemesterDropDown(course, mainViewModel)
            ShouldRenderSubjectDropDown(
                subjects = subjects,
                onSubjectSelected = { mainViewModel.setChosenSubject(it) },
            )
            ShouldRenderSubjectDisplay(chosenSubject)
        }
    }
}

@Composable
private fun RenderSemesterDropDown(
    course: Course,
    mainViewModel: MainViewModel
) {
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        SemesterDropDown(
            course.amountOfSemesters,
            onSemesterChosen = { semesterNumber ->
                mainViewModel.fetchSubjectsForSemester(semesterNumber)
            }
        )
    }
}

@Composable
private fun ShouldRenderSubjectDisplay(chosenSubject: Subject?) {
    if (chosenSubject != null) {
        Spacer(modifier = Modifier.height(15.dp))
        SubjectDisplay(subject = chosenSubject)
    }
}

@Composable
private fun ShouldRenderSubjectDropDown(
    subjects: List<Subject>?,
    onSubjectSelected: (subject: Subject) -> Unit = {}
) {
    if (subjects != null) {
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            SubjectDropDown(
                subjects,
                onSubjectSelected,
            )
        }
    }
}