package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.data_sources.MockDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.MockCourseRepositoryImpl

class CourseRepositoryFactory {

    fun build(): CourseRepository {
        return MockCourseRepositoryImpl(MockDataSource())
    }
}