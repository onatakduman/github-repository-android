package com.onatakduman.githubrepo.data.remote.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class License(
    @Json(name = "key") val key: String = "",
    @Json(name = "name") val name: String = "",
    @Json(name = "spdx_id") val spdxId: String = "",
    @Json(name = "url") val url: String = "",
    @Json(name = "node_id") val nodeId: String = ""
) : Parcelable