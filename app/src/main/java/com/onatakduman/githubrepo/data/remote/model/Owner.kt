package com.onatakduman.githubrepo.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Owner(

    @Json(name="login") @Expose val login: String = "",
    @Json(name="id") @Expose val id: Int = 0,
    @Json(name="node_id") @Expose val node_id: String = "",
    @Json(name="avatar_url") @Expose val avatar_url: String = "",
    @Json(name="gravatar_id") @Expose val gravatar_id: String = "",
    @Json(name="url") @Expose val url: String = "",
    @Json(name="html_url") @Expose val html_url: String = "",
    @Json(name="followers_url") @Expose val followers_url: String = "",
    @Json(name="following_url") @Expose val following_url: String = "",
    @Json(name="gists_url") @Expose val gists_url: String = "",
    @Json(name="starred_url") @Expose val starred_url: String = "",
    @Json(name="subscriptions_url") @Expose val subscriptions_url: String = "",
    @Json(name="organizations_url") @Expose val organizations_url: String = "",
    @Json(name="repos_url") @Expose val repos_url: String = "",
    @Json(name="events_url") @Expose val events_url: String = "",
    @Json(name="received_events_url") @Expose val received_events_url: String = "",
    @Json(name="type") @Expose val type: String = "",
    @Json(name="site_admin") @Expose val site_admin: Boolean = false

):Parcelable