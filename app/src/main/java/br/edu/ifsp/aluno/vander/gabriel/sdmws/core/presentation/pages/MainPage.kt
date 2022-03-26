package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
    var chosenSemester: Int? by remember { mutableStateOf(null) }

    mainViewModel.fetchCourse()

    Scaffold(modifier = Modifier.padding(15.dp)) {
        if (course == null) {
            Text(text = "Loading...")
        } else {
            Column(modifier = Modifier) {
                CourseDisplay(course!!)
                Spacer(modifier = Modifier.height(15.dp))
                SemesterDropDown(
                    course!!.amountOfSemesters,
                    onSemesterChosen = { chosenSemester = it }
                )
                Spacer(modifier = Modifier.height(15.dp))
                if (chosenSemester != null) {
                    mainViewModel.fetchSubjectsForSemester(chosenSemester!!)
                    SubjectDropDown(subjects)
                }
            }
        }
    }
}