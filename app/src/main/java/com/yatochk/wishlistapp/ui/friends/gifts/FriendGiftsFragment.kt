package com.yatochk.wishlistapp.ui.friends.gifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlistapp.databinding.FragmentFriendGiftListBinding
import com.yatochk.wishlistapp.domain.GetFriendWishListUseCase
import com.yatochk.wishlistapp.ui.GiftsFragment
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

    private val adapterUser: FriendGiftAdapter by lazy {
        FriendGiftAdapter(layoutInflater, ::onGiftLinkClick)
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
        friendName?.let {
            getFriendWishListUseCase.get(it).observe(viewLifecycleOwner) { gifts ->
                adapterUser.submitList(gifts)
            }
        }
        binding?.apply {
            setupRecycler()
        }
    }

    private fun FragmentFriendGiftListBinding.setupRecycler() {
        recyclerGifts.adapter = adapterUser
        recyclerGifts.layoutManager = LinearLayoutManager(context)
    }

}