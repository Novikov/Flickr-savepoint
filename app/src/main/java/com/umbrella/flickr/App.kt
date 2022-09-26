package com.umbrella.flickr

import android.app.Application
import com.umbrella.flickr.di.AppComponent
import com.umbrella.flickr.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        val retrofit = appComponent.retrofit()
    }
}
