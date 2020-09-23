package com.onatakduman.githubrepo.data.remote.api

import com.onatakduman.githubrepo.data.remote.model.Repository
import retrofit2.Call
import retrofit2.Response


interface ApiHelper {

    suspend fun getUserRepository(user: String): Call<List<Repository>>

}