package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.local.data_sources.MockDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.SubjectModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.SubjectRepository

class MockSubjectRepositoryImpl(
    private val mockDataSource: MockDataSource = MockDataSource()
) : SubjectRepository {
    override fun getSubjectsForSemester(semesterNumber: Int): List<Subject> {
        val subjectsForSemester: List<SubjectModel> =
            mockDataSource.getSubjectsForSemester(semesterNumber)
        return subjectsForSemester.map(this::toEntity)
    }

    private fun toEntity(model: SubjectModel): Subject {
        return Subject(
            name = model.name,
            tag = model.tag,
            amountOfClasses = model.classes,
            workloadInHours = model.hours,
        )
    }
}