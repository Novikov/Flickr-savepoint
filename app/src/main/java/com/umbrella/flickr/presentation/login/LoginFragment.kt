package com.umbrella.flickr.presentation.login

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.umbrella.flickr.R
import com.umbrella.flickr.utils.appComponent
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModel.Factory.Factory

    private val viewModel: LoginViewModel by viewModels {
        loginViewModelFactory.create()
    }

    override fun onAttach(context: Context) {
        requireContext().appComponent.inject(this)
        super.onAttach(context)
    }
}
