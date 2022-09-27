package com.umbrella.flickr.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.umbrella.flickr.domain.repository.FlickrRepository
import com.umbrella.flickr.utils.logErrorIfDebug
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val flickrRepository: FlickrRepository) :
    ViewModel() {

    fun getRequestToken() {
        viewModelScope.launch {
            runCatching {
                flickrRepository.getRequestToken()
            }.onSuccess {
                Log.i("ASDASDASD", "sucess")
            }
                .onFailure {
                    logErrorIfDebug(it)
                }
        }
    }

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
