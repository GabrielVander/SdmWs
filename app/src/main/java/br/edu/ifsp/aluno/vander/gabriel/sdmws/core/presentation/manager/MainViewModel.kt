package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.manager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases.GetCourseUseCase
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases.GetSubjectsForSemesterUseCase

class MainViewModel : ViewModel() {
    private val getCourseUseCase: GetCourseUseCase = GetCourseUseCase()
    private val getSubjectsForSemesterUseCase: GetSubjectsForSemesterUseCase =
        GetSubjectsForSemesterUseCase()

    private val _course: MutableLiveData<Course> = MutableLiveData()
    val course: LiveData<Course> = _course

    private val _subjects: MutableLiveData<List<Subject>> = MutableLiveData()
    val subjects: LiveData<List<Subject>> = _subjects

    fun fetchCourse() {
        val course: Course = getCourseUseCase.execute()
        _course.value = course
    }

    fun fetchSubjectsForSemester(semesterNumber: Int) {
        val subjects: List<Subject> = getSubjectsForSemesterUseCase.execute(semesterNumber)
        _subjects.value = subjects
    }

}