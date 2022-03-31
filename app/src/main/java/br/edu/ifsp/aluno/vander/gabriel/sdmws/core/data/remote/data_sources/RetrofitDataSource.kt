package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources

import android.util.Log
import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.SubjectModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitDataSource {
    private var retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var webService: RetrofitWebServiceApi =
        retrofit.create(RetrofitWebServiceApi::class.java)

    suspend fun getCourse(): CourseModel? {
        val courseResponse: Response<CourseModel> = webService.getCourse()

        if (courseResponse.isSuccessful) {
            return courseResponse.body()
        }

        Log.d(
            "RetrofitDataSource",
            "getCourse: ${courseResponse.errorBody()}"
        )

        return null
    }

    suspend fun getSubjectsForSemester(semester: Int): List<SubjectModel>? {
        val subjectResponse: Response<List<SubjectModel>> =
            webService.getSubjectsForSemester(semester)

        if (subjectResponse.isSuccessful) {
            return subjectResponse.body()
        }

        Log.d(
            "RetrofitDataSource",
            "getSubjectsForSemester: ${subjectResponse.errorBody()}"
        )

        return null
    }
}