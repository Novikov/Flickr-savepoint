package com.umbrella.flickr.data.remote_data_source

import java.net.URI

interface Endpoint {
    val title: String
    val url: URI
}

object Endpoints {
    val DEV: Endpoint =
        EndpointImpl(
            title = "Dev",
            url = URI.create("https://api.socium.in/api/")
        )
}

private data class EndpointImpl(
    override val title: String,
    override val url: URI
) : Endpoint
