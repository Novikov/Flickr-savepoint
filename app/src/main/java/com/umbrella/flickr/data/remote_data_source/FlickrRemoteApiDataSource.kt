package com.umbrella.flickr.data.remote_data_source

import com.umbrella.flickr.domain.models.galleries.Photos
import com.umbrella.flickr.domain.models.token.RequestToken

interface FlickrRemoteApiDataSource {
    suspend fun getRequestToken(): RequestToken
    suspend fun getPhotoList(): Photos
}
