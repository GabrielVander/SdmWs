package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.data_sources

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.models.CourseModel

class MockDataSource {
    private val course: CourseModel = CourseModel(
        "Some Course",
        "SC",
        340,
        3,
    )

    fun getCourse(): CourseModel {
        return course.copy()
    }
}