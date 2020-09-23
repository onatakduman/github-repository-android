package com.onatakduman.githubrepo.data.remote.api

import com.onatakduman.githubrepo.data.remote.model.Gist
import com.onatakduman.githubrepo.data.remote.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {

    @GET("users/{user}/repos")
    fun getUserRepositories(@Path("user") user: String): Call<List<Repository>>

    @GET("users/{user}/gists")
    fun getUserGists(@Path("user") user: String): Call<List<Gist>>

}