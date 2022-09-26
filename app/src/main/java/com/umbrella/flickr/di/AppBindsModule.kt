package com.umbrella.flickr.di

import com.umbrella.flickr.data.local_data_source.FlickrLocalApiDataSource
import com.umbrella.flickr.data.local_data_source.FlickrLocalApiDataSourceImpl
import com.umbrella.flickr.data.remote_data_source.FlickrRemoteApiDataSource
import com.umbrella.flickr.data.remote_data_source.FlickrRemoteApiDataSourceImp
import com.umbrella.flickr.domain.repository.FlickrRepository
import com.umbrella.flickr.domain.repository.FlickrRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {

    @Binds
    fun bindFlickrLocalApiDataSourceImpl_to_FlickrLocalApiDataSource(flickrLocalApiDataSourceImpl: FlickrLocalApiDataSourceImpl): FlickrLocalApiDataSource

    @Binds
    fun bindFlickrRemoteApiDataSourceImpl_to_FlickrRemoteApiDataSource(flickrRemoteApiDataSourceImp: FlickrRemoteApiDataSourceImp): FlickrRemoteApiDataSource

    @Binds
    fun bindFlickrRepositoryImpl_to_FlickrRepository(flickrRepositoryImpl: FlickrRepositoryImpl): FlickrRepository
}
