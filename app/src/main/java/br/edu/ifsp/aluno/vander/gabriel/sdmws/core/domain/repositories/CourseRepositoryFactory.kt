package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.RemoteCourseRepositoryImpl

class CourseRepositoryFactory {

    fun build(): CourseRepository {
        return RemoteCourseRepositoryImpl()
    }
}