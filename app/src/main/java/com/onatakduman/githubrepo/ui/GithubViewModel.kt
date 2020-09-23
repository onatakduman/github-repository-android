package com.onatakduman.githubrepo.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onatakduman.githubrepo.data.GithubRepository
import com.onatakduman.githubrepo.data.remote.model.Repository
import com.onatakduman.githubrepo.data.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class GithubViewModel @ViewModelInject constructor(private val repository: GithubRepository) :
    ViewModel() {

    val selectedRepo = MutableLiveData<String>()

    private val _repos = MutableLiveData<Resource<List<Repository>>>()
    val repos: LiveData<Resource<List<Repository>>>
        get() = _repos

    fun getUserRepos(user: String) {
        viewModelScope.launch {
            _repos.postValue(Resource.loading(null))
            repository.getUserRepos(user = user).enqueue(object : Callback<List<Repository>> {
                override fun onResponse(
                    call: Call<List<Repository>>,
                    response: Response<List<Repository>>
                ) {
                    if (response.isSuccessful)
                        _repos.postValue(Resource.success(response.body()))
                    else
                        _repos.postValue(Resource.error(response.errorBody().toString(), null))
                }

                override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                    _repos.postValue(Resource.error(t.localizedMessage, null))
                }

            })
        }
    }

}