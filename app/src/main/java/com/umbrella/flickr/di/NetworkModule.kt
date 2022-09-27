package com.umbrella.flickr.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.umbrella.flickr.BuildConfig
import com.umbrella.flickr.data.remote_data_source.network.Endpoint
import com.umbrella.flickr.data.remote_data_source.network.Endpoints
import com.umbrella.flickr.data.remote_data_source.network.NetworkConst
import com.umbrella.flickr.data.remote_data_source.network.api_service.LoginApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        return httpLoggingInterceptor
    }

    @Provides
    fun provideOkHttpProvider(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(NetworkConst.TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .connectTimeout(NetworkConst.TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
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

    @Provides
    fun provideLoginApiService(retrofit: Retrofit): LoginApiService {
        return retrofit.create(LoginApiService::class.java)
    }
}
