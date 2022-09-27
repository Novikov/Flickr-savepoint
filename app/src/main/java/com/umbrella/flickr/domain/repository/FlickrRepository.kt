package com.umbrella.flickr.domain.repository

import com.umbrella.flickr.domain.models.RequestToken

interface FlickrRepository {
    suspend fun getRequestToken(): RequestToken
}
