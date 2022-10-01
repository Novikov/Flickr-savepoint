package com.umbrella.flickr.data.remote_data_source

import com.umbrella.flickr.data.remote_data_source.mappers.GalleriesMapper
import com.umbrella.flickr.data.remote_data_source.mappers.LoginMapper
import com.umbrella.flickr.data.remote_data_source.network.api_service.GalleriesApiService
import com.umbrella.flickr.data.remote_data_source.network.api_service.LoginApiService
import com.umbrella.flickr.domain.models.galleries.Photos
import com.umbrella.flickr.domain.models.token.RequestToken
import javax.inject.Inject

// TODO: Igor divide remote api data source impl after implementing base aout
class FlickrRemoteApiDataSourceImp @Inject constructor(
    val loginApiService: LoginApiService,
    val galleryApiService: GalleriesApiService,
    val loginMapper: LoginMapper,
    val galleriesMapper: GalleriesMapper
) : FlickrRemoteApiDataSource {
    override suspend fun getRequestToken(): RequestToken {
        val response = loginApiService.getRequestToken()
        return loginMapper.toRequestToken(response)
    }

    override suspend fun getPhotoList(): Photos {
        val response = galleryApiService.getInterestingnessPhotos()
        return galleriesMapper.toPhotos(response)
    }
}
