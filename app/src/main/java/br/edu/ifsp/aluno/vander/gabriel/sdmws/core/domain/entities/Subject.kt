package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.domain.entities

data class Subject(
    val name: String,
    val tag: String,
    val workloadInHours: Int,
    val amountOfClasses: Int,
)
