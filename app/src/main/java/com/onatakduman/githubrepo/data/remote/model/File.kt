package com.onatakduman.githubrepo.data.remote.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class File (

	@Json(name="filename") val filename : String,
	@Json(name="type") val type : String,
	@Json(name="language") val language : String,
	@Json(name="raw_url") val raw_url : String,
	@Json(name="size") val size : Int
)