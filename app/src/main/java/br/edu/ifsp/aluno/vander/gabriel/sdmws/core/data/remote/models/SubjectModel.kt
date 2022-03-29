package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models

import com.google.gson.annotations.SerializedName

data class SubjectModel(
    @SerializedName("nome")
    val name: String,

    @Suppress("SpellCheckingInspection")
    @SerializedName("sigla")
    val tag: String,

    @SerializedName("horas")
    val hours: Int,

    @Suppress("SpellCheckingInspection")
    @SerializedName("aulas")
    val classes: Int,
)
