package com.umbrella.flickr.presentation.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.umbrella.flickr.R
import com.umbrella.flickr.databinding.FragmentLoginBinding
import com.umbrella.flickr.utils.appComponent
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var loginViewModelFactory: LoginViewModel.Factory.Factory
    private var viewBinding: FragmentLoginBinding? = null

    private val viewModel: LoginViewModel by viewModels {
        loginViewModelFactory.create()
    }

    override fun onAttach(context: Context) {
        requireContext().appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding?.loginButton?.setOnClick {
            viewModel.getRequestToken()
        }
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}
