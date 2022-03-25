package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.data_sources

import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.models.CourseModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.models.SubjectModel

class MockDataSource {
    private val course: CourseModel = CourseModel(
        "Some Course",
        "SC",
        340,
        3,
    )

    private val subjects1: List<SubjectModel> = listOf(
        SubjectModel(name = "Lighten", tag = "LTN", classes = 10, hours = 40),
        SubjectModel(name = "Mankind", tag = "MKD", classes = 235, hours = 940),
        SubjectModel(name = "Content", tag = "CNT", classes = 176, hours = 704),
    )

    private val subjects2: List<SubjectModel> = listOf(
        SubjectModel(name = "Network", tag = "NTW", classes = 10, hours = 40),
        SubjectModel(name = "Borrow", tag = "BOR", classes = 701, hours = 894),
        SubjectModel(name = "Scrape", tag = "SCR", classes = 453, hours = 537),
        SubjectModel(name = "Avenue", tag = "AVE", classes = 388, hours = 285),
    )

    private val subjects3: List<SubjectModel> = listOf(
        SubjectModel(name = "Forget", tag = "FGT", classes = 719, hours = 201),
        SubjectModel(name = "Freeze", tag = "FRZ", classes = 584, hours = 438),
    )

    fun getCourse(): CourseModel {
        return course.copy()
    }

    fun getSubjectsForSemester(semesterNumber: Int): List<SubjectModel> {
        if (semesterNumber == 1) {
            return subjects1
        }
        if (semesterNumber == 2) {
            return subjects2
        }

        return subjects3
    }
}