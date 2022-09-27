package com.umbrella.flickr.data.remote_data_source

import com.umbrella.flickr.domain.models.RequestToken

interface FlickrRemoteApiDataSource {
    suspend fun getRequestToken(): RequestToken
}
