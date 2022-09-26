package com.umbrella.flickr.data.remote_data_source

import javax.inject.Inject

class FlickrRemoteApiDataSourceImp @Inject constructor() : FlickrRemoteApiDataSource {
    override suspend fun requestToken() {}
}
