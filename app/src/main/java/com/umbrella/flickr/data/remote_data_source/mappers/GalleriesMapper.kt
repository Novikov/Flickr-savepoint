package com.umbrella.flickr.data.remote_data_source.mappers

import com.umbrella.flickr.data.remote_data_source.models.galleries.PhotoResponse
import com.umbrella.flickr.data.remote_data_source.models.galleries.PhotosResponse
import com.umbrella.flickr.domain.models.galleries.Photo
import com.umbrella.flickr.domain.models.galleries.Photos
import javax.inject.Inject

class GalleriesMapper @Inject constructor() {
    private fun toPhoto(photoResponse: PhotoResponse): Photo = with(photoResponse) {
        return Photo(
            id = id,
            owner = owner,
            secret = secret,
            server = server,
            farm = farm,
            title = title,
            ispublic = ispublic,
            isfriend = isfriend,
            isfamily = isfamily,
            ownername = ownername,
            realname = realname,
            iconserver = iconserver,
            iconfarm = iconfarm,
            countFaves = countFaves,
            countComments = countComments
        )
    }

    fun toPhotos(photosResponse: PhotosResponse): Photos = with(photosResponse) {
        return Photos(
            page = page,
            pages = pages,
            perpage = perpage,
            total = total,
            photo = photo.map(::toPhoto)
        )
    }
}
