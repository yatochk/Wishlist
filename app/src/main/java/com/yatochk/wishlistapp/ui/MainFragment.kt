package com.yatochk.wishlistapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.wishlist.common.ui.BaseFragment
import com.yatochk.wishlist.common.utils.showFragment
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.databinding.FragmentMainBinding
import com.yatochk.wishlistapp.ui.friends.FriendsWishListsFragment
import com.yatochk.wishlistapp.ui.user.gifts.UserGiftsFragment

class MainFragment : BaseFragment<FragmentMainBinding>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val myGiftsFragment by lazy { UserGiftsFragment() }
    private val friendsWishListsFragment by lazy { FriendsWishListsFragment() }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFragment(R.id.contentFragment, myGiftsFragment)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding?.bottomNavigation?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.my_list -> showFragment(R.id.contentFragment, myGiftsFragment)
                R.id.other_lists -> showFragment(R.id.contentFragment, friendsWishListsFragment)
            }
            true
        }
    }
}