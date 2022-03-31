package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources.VolleyDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.SubjectModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.SubjectRepository

class VolleySubjectRepositoryImpl(
    private val volleyDataSource: VolleyDataSource = VolleyDataSource()
) : SubjectRepository {

    override suspend fun getSubjectsForSemester(semesterNumber: Int): List<Subject>? {
        val models: List<SubjectModel> = volleyDataSource.getSubjectsForSemester(semesterNumber)
            ?: return null

        return models.map { toEntity(it) }
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