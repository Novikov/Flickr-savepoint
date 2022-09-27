package com.umbrella.flickr.data.remote_data_source.models.login

import com.squareup.moshi.Json

data class RequestTokenResponse(
    @Json(name = "oauth_token")
    val oauth_token: String,
    @Json(name = "oauth_token_secret")
    val oauth_token_secret: String
)
