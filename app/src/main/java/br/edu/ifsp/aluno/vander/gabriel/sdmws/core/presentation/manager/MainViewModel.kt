package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.manager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases.GetCourseUseCase

class MainViewModel: ViewModel() {
    private val getCourseUseCase: GetCourseUseCase = GetCourseUseCase()

    private val _course: MutableLiveData<Course> = MutableLiveData()
    val course: LiveData<Course> = _course

    fun fetchCourse() {
        val course: Course = getCourseUseCase.execute()
        _course.value = course
    }

}