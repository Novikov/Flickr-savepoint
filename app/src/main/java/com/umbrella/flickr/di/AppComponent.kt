package com.umbrella.flickr.di

import com.umbrella.flickr.presentation.login.LoginFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(loginFragment: LoginFragment) // Может быть названа как угодно
}
