package com.yatochk.wishlistapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yatochk.wishlist.common.utils.showFragment
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.databinding.ActivityMainBinding
import com.yatochk.wishlistapp.login.api.LoginListener
import com.yatochk.wishlistapp.login.api.navigation.LoginRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), LoginListener {

    @Inject
    lateinit var loginRouter: LoginRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(R.id.fragment, loginRouter.getLoginFragment())
    }

    override fun onLoginSuccess() {
        showFragment(R.id.fragment, MainFragment.newInstance())
    }

}