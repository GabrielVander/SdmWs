package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.pages

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.manager.MainViewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.widgets.CourseDisplay

@Composable
fun MainPage(mainViewModel: MainViewModel = viewModel()) {
    val course: Course? by mainViewModel.course.observeAsState()

    mainViewModel.fetchCourse()

    if (course == null) {
        Text(text = "Loading...")
    } else {
        CourseDisplay(course!!)
    }

}