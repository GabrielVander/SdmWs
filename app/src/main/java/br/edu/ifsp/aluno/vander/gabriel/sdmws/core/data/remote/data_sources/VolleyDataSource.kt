package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources

import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.NoCache
import com.google.gson.Gson
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class VolleyDataSource {
    private val cache = NoCache()
    private val network = BasicNetwork(HurlStack())

    private val requestQueue = RequestQueue(cache, network).apply {
        start()
    }

    suspend fun getCourse(): CourseModel? {
        return suspendCoroutine { continuation ->
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                Constants.BASE_URL + Constants.COURSE_ENDPOINT,
                null,
                { response ->
                    if (response != null) {
                        val gson = Gson()
                        continuation.resume(
                            gson.fromJson(
                                response.toString(),
                                CourseModel::class.java
                            )
                        )
                    }
                },
                { continuation.resume(null) }
            )

            requestQueue.add(jsonObjectRequest)
        }
    }
}