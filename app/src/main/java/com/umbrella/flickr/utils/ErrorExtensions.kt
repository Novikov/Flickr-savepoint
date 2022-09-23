package com.umbrella.flickr.utils

import com.umbrella.flickr.BuildConfig

fun logErrorIfDebug(throwable: Throwable) {
    if (BuildConfig.DEBUG) {
        throwable.printStackTrace()
    }
}