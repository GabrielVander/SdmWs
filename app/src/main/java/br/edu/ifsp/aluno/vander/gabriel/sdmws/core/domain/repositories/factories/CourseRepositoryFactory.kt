package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.data_sources.MockDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.MockCourseRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.CourseRepository

class CourseRepositoryFactory {

    fun build(): CourseRepository {
        return MockCourseRepositoryImpl(MockDataSource())
    }
}