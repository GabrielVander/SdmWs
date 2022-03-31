package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.use_cases

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.SubjectRepository
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories.SubjectRepositoryFactory

class GetSubjectsForSemesterUseCase(
    private val subjectRepository: SubjectRepository = SubjectRepositoryFactory()
        .build()
) {

    suspend fun execute(semesterNumber: Int): List<Subject>? {
        return subjectRepository.getSubjectsForSemester(semesterNumber)
    }

}