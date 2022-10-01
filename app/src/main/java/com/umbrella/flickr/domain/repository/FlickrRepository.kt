package com.umbrella.flickr.domain.repository

import com.umbrella.flickr.domain.models.galleries.Photos
import com.umbrella.flickr.domain.models.token.RequestToken

interface FlickrRepository {
    suspend fun getRequestToken(): RequestToken
    suspend fun getPhotoList(): Photos
}
