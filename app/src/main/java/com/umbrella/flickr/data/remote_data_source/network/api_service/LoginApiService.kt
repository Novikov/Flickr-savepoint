package com.umbrella.flickr.data.remote_data_source.network.api_service

import com.umbrella.flickr.data.remote_data_source.models.login.RequestTokenResponse
import retrofit2.http.GET

interface LoginApiService {
    @GET("/services/oauth/request_token")
    suspend fun getRequestToken(): RequestTokenResponse
}
