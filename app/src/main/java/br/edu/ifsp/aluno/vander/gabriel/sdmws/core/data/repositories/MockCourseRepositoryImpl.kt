package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.local.data_sources.MockDataSource
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.CourseRepository

class MockCourseRepositoryImpl(
    private val mockDataSource: MockDataSource = MockDataSource()
) : CourseRepository {

    override suspend fun getCourse(): Course {
        val courseModel: CourseModel = mockDataSource.getCourse()

        return toEntity(courseModel)
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