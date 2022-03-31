package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Environment
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.MockCourseRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.RetrofitCourseRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.VolleyCourseRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.CourseRepository

class CourseRepositoryFactory {

    fun build(): CourseRepository {
        if (Constants.ENV == Environment.REMOTE_RETROFIT) {
            return RetrofitCourseRepositoryImpl()
        } else if (Constants.ENV == Environment.REMOTE_VOLLEY) {
            return VolleyCourseRepositoryImpl()
        }
        return MockCourseRepositoryImpl()
    }
}