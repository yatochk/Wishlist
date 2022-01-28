package com.yatochk.wishlistapp.login.impl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.wishlist.common.ui.BaseFragment
import com.yatochk.wishlist.common.utils.lifecycleLaunch
import com.yatochk.wishlistapp.login.api.LoginListener
import com.yatochk.wishlistapp.login.databinding.FragmentLoginBinding
import com.yatochk.wishlistapp.login.impl.domain.LoginUseCase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private val listener get() = activity as? LoginListener

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkLogin()
        binding?.initView()
    }

    private fun FragmentLoginBinding.initView() {
        buttonLogin.setOnClickListener {
            onLoginClicked()
        }
    }

    private fun onLoginClicked() {
        lifecycleLaunch {
            loginUseCase.login(binding?.editTextName?.text.toString()).collect {
                if (it) {
                    listener?.onLoginSuccess()
                }
            }
        }
    }

    private fun checkLogin() {
        lifecycleLaunch {
            loginUseCase.checkLogin().collect {
                if (it) {
                    listener?.onLoginSuccess()
                }
            }
        }
    }
}