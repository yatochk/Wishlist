package com.yatochk.wishlistapp.login.impl.navigation

import androidx.fragment.app.Fragment
import com.yatochk.wishlistapp.login.api.navigation.LoginRouter
import com.yatochk.wishlistapp.login.impl.ui.LoginFragment
import javax.inject.Inject

internal class LoginRouterImpl @Inject constructor() : LoginRouter {
    override fun getLoginFragment(): Fragment {
        return LoginFragment.newInstance()
    }
}