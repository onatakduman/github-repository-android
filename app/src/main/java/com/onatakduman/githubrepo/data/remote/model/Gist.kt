package com.onatakduman.githubrepo.data.remote.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class Gist (

	@Json(name="url") val url : String,
	@Json(name="forks_url") val forks_url : String,
	@Json(name="commits_url") val commits_url : String,
	@Json(name="id") val id : String,
	@Json(name="node_id") val node_id : String,
	@Json(name="git_pull_url") val git_pull_url : String,
	@Json(name="git_push_url") val git_push_url : String,
	@Json(name="html_url") val html_url : String,
	@Json(name="files") val files : Files,
	@Json(name="public") val public : Boolean,
	@Json(name="created_at") val created_at : String,
	@Json(name="updated_at") val updated_at : String,
	@Json(name="description") val description : String,
	@Json(name="comments") val comments : Int,
	@Json(name="user") val user : String,
	@Json(name="comments_url") val comments_url : String,
	@Json(name="owner") val owner : Owner,
	@Json(name="truncated") val truncated : Boolean
)