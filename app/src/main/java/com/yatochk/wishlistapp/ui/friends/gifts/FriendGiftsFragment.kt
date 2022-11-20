package com.yatochk.wishlistapp.ui.friends.gifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlist.common.utils.lifecycleLaunch
import com.yatochk.wishlistapp.databinding.FragmentFriendGiftListBinding
import com.yatochk.wishlistapp.domain.GetFriendWishListUseCase
import com.yatochk.wishlistapp.ui.base.GiftsFragment
import com.yatochk.wishlistapp.ui.user.gifts.GiftAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FriendGiftsFragment : GiftsFragment<FragmentFriendGiftListBinding>() {

    companion object {
        private const val FRIEND_NAME_KEY = "friend_name"

        fun newInstance(friendName: String): FriendGiftsFragment {
            return FriendGiftsFragment().apply {
                arguments = bundleOf(
                    FRIEND_NAME_KEY to friendName
                )
            }
        }
    }

    @Inject
    lateinit var getFriendWishListUseCase: GetFriendWishListUseCase

    private val adapter: GiftAdapter by lazy {
        GiftAdapter(layoutInflater, ::onGiftClick)
    }

    private val friendName get() = requireArguments().getString(FRIEND_NAME_KEY)

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFriendGiftListBinding {
        return FragmentFriendGiftListBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            setupRecycler()
        }
        friendName?.let {
            lifecycleLaunch {
                getFriendWishListUseCase.get(it).collect { gifts ->
                    adapter.submitList(gifts)
                }
            }
        }
    }

    private fun FragmentFriendGiftListBinding.setupRecycler() {
        recyclerGifts.adapter = adapter
        recyclerGifts.layoutManager = LinearLayoutManager(context)
    }

}