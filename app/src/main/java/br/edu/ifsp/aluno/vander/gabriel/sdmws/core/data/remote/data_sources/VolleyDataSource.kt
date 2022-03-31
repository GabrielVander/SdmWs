package br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.data_sources

import android.util.Log
import br.edu.ifsp.aluno.vander.gabriel.sdmws.config.Constants
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.CourseModel
import br.edu.ifsp.aluno.vander.gabriel.sdmws.core.data.remote.models.SubjectModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.*
import com.google.gson.Gson
import org.json.JSONObject
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
                { error ->
                    Log.d(
                        "VolleyDataSource",
                        "getCourse: $error"
                    )
                    continuation.resume(null)
                }
            )

            requestQueue.add(jsonObjectRequest)
        }
    }

    suspend fun getSubjectsForSemester(semester: Int): List<SubjectModel>? {
        return suspendCoroutine { continuation ->
            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                Constants.BASE_URL + Constants.SEMESTER_ENDPOINT + "/" + semester.toString(),
                null,
                { response ->
                    response?.also { semesterJsonArray ->
                        val gson = Gson()

                        val subjects: MutableList<SubjectModel> = mutableListOf()
                        for (index in 0 until semesterJsonArray.length()) {
                            val subjectJsonObject: JSONObject =
                                semesterJsonArray.getJSONObject(index)
                            val subjectModel = gson.fromJson(
                                subjectJsonObject.toString(),
                                SubjectModel::class.java
                            )
                            subjects.add(subjectModel)
                        }
                        continuation.resume(subjects)
                    }
                },
                { error ->
                    Log.d(
                        "VolleyDataSource",
                        "getSubjectsForSemester: $error"
                    )
                    continuation.resume(null)
                }
            )

            requestQueue.add(jsonArrayRequest)
        }
    }
}