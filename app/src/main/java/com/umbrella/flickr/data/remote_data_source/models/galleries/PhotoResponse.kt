package com.umbrella.flickr.data.remote_data_source.models.galleries

import com.squareup.moshi.Json

data class PhotoResponse(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Long,
    val title: String,
    val ispublic: Long,
    val isfriend: Long,
    val isfamily: Long,
    val ownername: String,
    val realname: String? = null,
    val iconserver: String,
    val iconfarm: Long,

    @Json(name = "count_faves")
    val countFaves: String,

    @Json(name = "count_comments")
    val countComments: String
)
