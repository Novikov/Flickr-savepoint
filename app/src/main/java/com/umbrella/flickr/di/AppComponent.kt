package com.umbrella.flickr.di

import com.umbrella.flickr.presentation.login.LoginFragment
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [AppModule::class])
interface AppComponent {
    fun retrofit(): Retrofit
    fun inject(loginFragment: LoginFragment) //Может быть названа как угодно
}
