package com.umbrella.flickr.data.remote_data_source

interface FlickrRemoteApiDataSource {
    suspend fun requestToken()
}
