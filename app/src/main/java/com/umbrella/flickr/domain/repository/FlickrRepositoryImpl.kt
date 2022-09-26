package com.umbrella.flickr.domain.repository

import com.umbrella.flickr.data.local_data_source.FlickrLocalApiDataSource
import com.umbrella.flickr.data.remote_data_source.FlickrRemoteApiDataSource
import javax.inject.Inject

class FlickrRepositoryImpl @Inject constructor(
    private val flickrRemoteApiDataSource: FlickrRemoteApiDataSource,
    private val flickrLocalApiDataSource: FlickrLocalApiDataSource
) : FlickrRepository
