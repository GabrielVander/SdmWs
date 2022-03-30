package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
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

    mainViewModel.fetchCourse()

    Scaffold(modifier = Modifier.padding(15.dp)) {
        RenderContent(mainViewModel, course)
    }
}

@Composable
private fun RenderContent(
    mainViewModel: MainViewModel,
    course: Course?,
) {
    Column(modifier = Modifier) {
        if (course == null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                CircularProgressIndicator()
            }
        } else {
            Content(
                mainViewModel,
                course
            )
        }
    }
}

@Composable
private fun Content(
    mainViewModel: MainViewModel,
    course: Course
) {
    val subjects: List<Subject>? by mainViewModel.subjects.observeAsState()
    val chosenSubject: Subject? by mainViewModel.chosenSubject.observeAsState()
    val isLoadingSubjects: Boolean? by mainViewModel.isLoadingSubjects.observeAsState()

    CourseDisplay(course)
    RenderSemesterDropDown(mainViewModel, course)
    ShouldRenderSubjectDropDown(
        subjects = subjects,
        isLoading = isLoadingSubjects ?: false,
        onSubjectSelected = { mainViewModel.setChosenSubject(it) },
    )
    ShouldRenderSubjectDisplay(chosenSubject)
}

@Composable
private fun RenderSemesterDropDown(
    mainViewModel: MainViewModel,
    course: Course
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
    isLoading: Boolean = false,
    onSubjectSelected: (subject: Subject) -> Unit = {}
) {
    Spacer(modifier = Modifier.height(15.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        if (subjects != null && !isLoading) {
            SubjectDropDown(
                subjects,
                onSubjectSelected,
            )
        } else if (isLoading) {
            CircularProgressIndicator()
        }
    }

}