package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities.Subject

interface SubjectRepository {

    fun getSubjectsForSemester(semesterNumber: Int): List<Subject>

}