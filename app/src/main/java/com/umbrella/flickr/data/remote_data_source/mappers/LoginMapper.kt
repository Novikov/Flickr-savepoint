package com.umbrella.flickr.data.remote_data_source.mappers

import com.umbrella.flickr.data.remote_data_source.models.login.RequestTokenResponse
import com.umbrella.flickr.domain.models.RequestToken
import javax.inject.Inject

class LoginMapper @Inject constructor() {
    fun toRequestToken(requestTokenResponse: RequestTokenResponse): RequestToken =
        with(requestTokenResponse) {
            return RequestToken(oauthToken = oauth_token, oauthTokenSecret = oauth_token_secret)
        }
}
