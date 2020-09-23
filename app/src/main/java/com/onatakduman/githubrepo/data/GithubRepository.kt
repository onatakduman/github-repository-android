package com.onatakduman.githubrepo.data

import com.onatakduman.githubrepo.data.remote.api.ApiHelper
import javax.inject.Inject

class GithubRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUserRepos(user: String) = apiHelper.getUserRepository(user)
}