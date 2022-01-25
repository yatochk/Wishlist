package com.yatochk.wishlistapp.login.impl.navigation

import androidx.fragment.app.Fragment
import com.yatochk.wishlistapp.login.api.navigation.LoginRouter
import com.yatochk.wishlistapp.login.impl.ui.LoginFragment

internal class LoginRouterImpl : LoginRouter {
    override fun getLoginFragment(): Fragment {
        return LoginFragment.newInstance()
    }
}