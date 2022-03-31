package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities

data class Course(
    val name: String,
    val tag: String,
    val workloadInHours: Int,
    val amountOfSemesters: Int
)
