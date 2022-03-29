package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources.RetrofitDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.SubjectModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.SubjectRepository

class RetrofitSubjectRepositoryImpl(
    private val retrofitDataSource: RetrofitDataSource = RetrofitDataSource()
) : SubjectRepository {

    override suspend fun getSubjectsForSemester(semesterNumber: Int): List<Subject>? {
        val subjects: List<SubjectModel> =
            retrofitDataSource.getSubjectsForSemester(semesterNumber) ?: return null
        return subjects.map { toEntity(it) }
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