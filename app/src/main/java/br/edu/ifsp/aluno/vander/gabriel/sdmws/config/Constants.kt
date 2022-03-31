@file:Suppress("SpellCheckingInspection")

package br.edu.ifsp.aluno.vander.gabriel.sdmws.config

object Constants {
    const val BASE_URL: String = "https://nobile.pro.br/sdm_ws/"
    const val COURSE_ENDPOINT: String = "curso"
    const val SEMESTER_ENDPOINT: String = "semestre"
    const val SEMESTER_PATH_VARIABLE_NAME: String = "semesterNumber"
    const val SEMESTER_ENDPOINT_WITH_PATH_VARIABLE: String = "semestre/{$SEMESTER_PATH_VARIABLE_NAME}"
    val ENV: Environment = Environment.REMOTE_RETROFIT
}