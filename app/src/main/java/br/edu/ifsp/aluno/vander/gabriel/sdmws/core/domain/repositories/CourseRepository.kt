package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Course

interface CourseRepository {

    suspend fun getCourse(): Course?
}