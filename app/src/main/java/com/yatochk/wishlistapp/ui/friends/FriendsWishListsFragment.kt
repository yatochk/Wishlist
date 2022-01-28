package com.yatochk.wishlistapp.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.friends.Friend
import com.yatochk.wishlistapp.databinding.FragmentFriendsWishListsBinding
import com.yatochk.wishlistapp.domain.GetFriendsUseCase
import com.yatochk.wishlistapp.ui.friends.gifts.FriendGiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FriendsWishListsFragment :
    com.yatochk.wishlist.common.ui.BaseFragment<FragmentFriendsWishListsBinding>() {

    @Inject
    lateinit var getFriendsUseCase: GetFriendsUseCase

    private val adapter: FriendsAdapter by lazy {
        FriendsAdapter(layoutInflater, ::onFriendClick)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFriendsWishListsBinding {
        return FragmentFriendsWishListsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.setupRecycler()
        getFriendsUseCase.get().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun FragmentFriendsWishListsBinding.setupRecycler() {
        friendRecycler.layoutManager = LinearLayoutManager(requireContext())
        friendRecycler.adapter = adapter
    }

    private fun onFriendClick(friend: Friend) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.contentFragment, FriendGiftsFragment.newInstance(friend.name))
            .commitAllowingStateLoss()
    }
}