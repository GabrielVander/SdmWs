package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.CourseRepository
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories.CourseRepositoryFactory

class GetCourseUseCase(
    private val courseRepository: CourseRepository = CourseRepositoryFactory()
        .build()
) {

    fun execute(): Course {
        return courseRepository.getCourse()
    }
}