package com.umbrella.flickr.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.umbrella.flickr.R
import com.umbrella.flickr.utils.appComponent
import retrofit2.Retrofit
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireContext().appComponent.inject(this)
    }
}
