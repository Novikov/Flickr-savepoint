package com.umbrella.flickr.di

import com.umbrella.flickr.data.local_data_source.FlickrLocalApiDataSource
import com.umbrella.flickr.data.local_data_source.FlickrLocalApiDataSourceImpl
import com.umbrella.flickr.data.remote_data_source.FlickrRemoteApiDataSource
import com.umbrella.flickr.data.remote_data_source.FlickrRemoteApiDataSourceImpl
import com.umbrella.flickr.domain.repository.FlickrRepository
import com.umbrella.flickr.domain.repository.FlickrRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
object AppModule {

    @Provides
    fun providesLocalDataSource(): FlickrLocalApiDataSource {
        return FlickrLocalApiDataSourceImpl()
    }

    @Provides
    fun providesRemoteDataSource(): FlickrRemoteApiDataSource {
        return FlickrRemoteApiDataSourceImpl()
    }

    @Provides
    fun provideRepository(
        flickrLocalApiDataSource: FlickrLocalApiDataSource,
        flickrRemoteApiDataSource: FlickrRemoteApiDataSource
    ): FlickrRepository {
        return FlickrRepositoryImpl(flickrRemoteApiDataSource, flickrLocalApiDataSource)
    }
}
