package com.umbrella.flickr.data.remote_data_source

import com.umbrella.flickr.data.remote_data_source.mappers.LoginMapper
import com.umbrella.flickr.data.remote_data_source.network.api_service.LoginApiService
import com.umbrella.flickr.domain.models.RequestToken
import javax.inject.Inject

class FlickrRemoteApiDataSourceImp @Inject constructor(
    val loginApiService: LoginApiService,
    val loginMapper: LoginMapper
) : FlickrRemoteApiDataSource {
    override suspend fun getRequestToken(): RequestToken {
        val response = loginApiService.getRequestToken()
        return loginMapper.toRequestToken(response)
    }
}
