package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources

import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
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

        return null
    }
}