package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.presentation.manager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases.GetCourseUseCase
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases.GetSubjectsForSemesterUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO + Job())
    private val getCourseUseCase: GetCourseUseCase = GetCourseUseCase()
    private val getSubjectsForSemesterUseCase: GetSubjectsForSemesterUseCase =
        GetSubjectsForSemesterUseCase()

    private val _course: MutableLiveData<Course> = MutableLiveData()
    val course: LiveData<Course> = _course

    private val _subjects: MutableLiveData<List<Subject>> = MutableLiveData()
    val subjects: LiveData<List<Subject>> = _subjects

    private val _chosenSubject: MutableLiveData<Subject> = MutableLiveData()
    val chosenSubject: LiveData<Subject> = _chosenSubject

    fun fetchCourse() {
        coroutineScope.launch {
            val course: Course? = getCourseUseCase.execute()
            if (course != null) {
                _course.postValue(course!!)
            }
        }
    }

    fun fetchSubjectsForSemester(semesterNumber: Int) {
        val subjects: List<Subject> = getSubjectsForSemesterUseCase.execute(semesterNumber)
        _subjects.value = subjects
    }

    fun setChosenSubject(subject: Subject) {
        _chosenSubject.value = subject
    }

}