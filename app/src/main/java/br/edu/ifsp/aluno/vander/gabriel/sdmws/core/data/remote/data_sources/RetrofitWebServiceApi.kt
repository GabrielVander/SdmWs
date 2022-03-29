package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources

import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.SubjectModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitWebServiceApi {

    @GET(Constants.COURSE_ENDPOINT)
    suspend fun getCourse(): Response<CourseModel>

    @GET(Constants.SEMESTER_ENDPOINT)
    suspend fun getSubjectsForSemester(
        @Path(Constants.SEMESTER_PATH_VARIABLE_NAME) semesterNumber: Int
    ): Response<List<SubjectModel>>

}