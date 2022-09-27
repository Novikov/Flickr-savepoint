package com.umbrella.flickr.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.umbrella.flickr.domain.repository.FlickrRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val flickrRepository: FlickrRepository) :
    ViewModel() {
    @Suppress("UNCHECKED_CAST")
    class Factory(private val flickrRepository: FlickrRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(flickrRepository) as T
        }

        class Factory @Inject constructor(val flickrRepository: FlickrRepository) {
            fun create(): LoginViewModel.Factory {
                return LoginViewModel.Factory(flickrRepository)
            }
        }
    }
}
