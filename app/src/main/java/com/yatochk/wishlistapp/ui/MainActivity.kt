package com.yatochk.wishlistapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.user.UserInfoRepository
import com.yatochk.wishlistapp.databinding.ActivityMainBinding
import com.yatochk.wishlistapp.ui.friends.FriendsWishListsFragment
import com.yatochk.wishlistapp.ui.user.gifts.UserGiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userInfoRepository: UserInfoRepository

    private val myGiftsFragment by lazy { UserGiftsFragment() }
    private val friendsWishListsFragment by lazy { FriendsWishListsFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userInfoRepository.setUserName("alexey")
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(myGiftsFragment)
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.my_list -> showFragment(myGiftsFragment)
                R.id.other_lists -> showFragment(friendsWishListsFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, fragment)
            .commitAllowingStateLoss()
    }

}