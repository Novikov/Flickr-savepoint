package com.umbrella.flickr.utils

import android.content.Context
import com.umbrella.flickr.App
import com.umbrella.flickr.di.AppComponent

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }
