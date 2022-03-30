package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.factories

import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Environment
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.MockSubjectRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.repositories.RetrofitSubjectRepositoryImpl
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.repositories.SubjectRepository

class SubjectRepositoryFactory {
    fun build(): SubjectRepository {
        if (Constants.ENV == Environment.REMOTE_RETROFIT) {
            return RetrofitSubjectRepositoryImpl()
        }
        return MockSubjectRepositoryImpl()
    }
}