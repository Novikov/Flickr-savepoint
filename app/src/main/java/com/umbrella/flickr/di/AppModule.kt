package com.umbrella.flickr.di

import dagger.Module

@Module(includes = [NetworkModule::class, AppBindsModule::class])
object AppModule
