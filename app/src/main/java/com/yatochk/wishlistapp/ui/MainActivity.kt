package com.yatochk.wishlistapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.UserInfoRepository
import com.yatochk.wishlistapp.databinding.ActivityMainBinding
import com.yatochk.wishlistapp.ui.gift.list.GiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userInfoRepository: UserInfoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userInfoRepository.setUserName("alexey")
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showGiftListFragment()
    }

    private fun showGiftListFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, GiftsFragment())
            .commitAllowingStateLoss()
    }

}