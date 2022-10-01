package com.umbrella.flickr.data.remote_data_source.models.galleries

data class PhotosResponse(
    val page: Long,
    val pages: Long,
    val perpage: Long,
    val total: Long,
    val photo: List<PhotoResponse>
)
