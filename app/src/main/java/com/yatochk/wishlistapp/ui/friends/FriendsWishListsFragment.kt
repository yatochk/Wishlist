package com.yatochk.wishlistapp.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.wishlistapp.databinding.FragmentFriendsWishListsBinding
import com.yatochk.wishlistapp.ui.BaseFragment

class FriendsWishListsFragment : BaseFragment<FragmentFriendsWishListsBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFriendsWishListsBinding {
        return FragmentFriendsWishListsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}