package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Environment
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.local.data_sources.MockDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.MockCourseRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.RetrofitCourseRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.CourseRepository

class CourseRepositoryFactory {

    fun build(): CourseRepository {
        if (Constants.ENV == Environment.REMOTE) {
            return RetrofitCourseRepositoryImpl()
        }
        return MockCourseRepositoryImpl(MockDataSource())
    }
}