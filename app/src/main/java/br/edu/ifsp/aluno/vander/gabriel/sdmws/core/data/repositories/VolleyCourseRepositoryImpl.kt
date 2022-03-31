package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources.VolleyDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.CourseRepository

class VolleyCourseRepositoryImpl(
    private val volleyDataSource: VolleyDataSource = VolleyDataSource()
) : CourseRepository {

    override suspend fun getCourse(): Course? {
        return toEntity(volleyDataSource.getCourse() ?: return null)
    }

    private fun toEntity(model: CourseModel): Course {
        return Course(
            name = model.name,
            tag = model.tag,
            workloadInHours = model.hours,
            amountOfSemesters = model.semesters,
        )
    }

}