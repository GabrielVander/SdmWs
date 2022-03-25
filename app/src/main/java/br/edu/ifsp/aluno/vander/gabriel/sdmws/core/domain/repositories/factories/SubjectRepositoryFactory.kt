package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.MockSubjectRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.SubjectRepository

class SubjectRepositoryFactory {
    fun build(): SubjectRepository {
        return MockSubjectRepositoryImpl()
    }
}