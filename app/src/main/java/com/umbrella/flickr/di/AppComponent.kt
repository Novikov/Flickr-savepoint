package com.umbrella.flickr.di

import com.umbrella.flickr.presentation.login.LoginFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(loginFragment: LoginFragment) // Может быть названа как угодно
}
