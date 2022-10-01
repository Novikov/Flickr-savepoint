package com.umbrella.flickr.domain.repository

import com.umbrella.flickr.data.local_data_source.FlickrLocalApiDataSource
import com.umbrella.flickr.data.remote_data_source.FlickrRemoteApiDataSource
import com.umbrella.flickr.domain.models.galleries.Photos
import com.umbrella.flickr.domain.models.token.RequestToken
import javax.inject.Inject

class FlickrRepositoryImpl @Inject constructor(
    private val flickrRemoteApiDataSource: FlickrRemoteApiDataSource,
    private val flickrLocalApiDataSource: FlickrLocalApiDataSource
) : FlickrRepository {
    override suspend fun getRequestToken(): RequestToken {
        return flickrRemoteApiDataSource.getRequestToken()
    }

    override suspend fun getPhotoList(): Photos {
        return flickrRemoteApiDataSource.getPhotoList()
    }
}
