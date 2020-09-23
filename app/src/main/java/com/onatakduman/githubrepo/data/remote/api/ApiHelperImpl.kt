package com.onatakduman.githubrepo.data.remote.api

import com.onatakduman.githubrepo.data.remote.model.Repository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class ApiHelperImpl @Inject constructor(private val apiInterface: ApiInterface) : ApiHelper {

    override suspend fun getUserRepository(user: String): Call<List<Repository>> =
        apiInterface.getUserRepositories(user)

}