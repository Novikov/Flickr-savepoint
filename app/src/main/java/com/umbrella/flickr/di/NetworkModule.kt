package com.umbrella.flickr.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.umbrella.flickr.data.remote_data_source.Endpoint
import com.umbrella.flickr.data.remote_data_source.Endpoints
import com.umbrella.flickr.data.remote_data_source.NetworkConst
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
object NetworkModule {
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    // TODO: Igor add interceptors
    @Provides
    fun provideOkHttpProvider(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(NetworkConst.TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .connectTimeout(NetworkConst.TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideEndpoint(): Endpoint {
        return Endpoints.DEV
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        jsonConverterFactory: Converter.Factory,
        endpoint: Endpoint
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endpoint.url.toURL())
            .client(okHttpClient)
            .addConverterFactory(jsonConverterFactory)
            .validateEagerly(true)
            .build()
    }
}
