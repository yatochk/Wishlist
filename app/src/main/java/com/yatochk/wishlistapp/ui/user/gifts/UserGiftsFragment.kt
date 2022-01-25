package com.yatochk.wishlistapp.ui.user.gifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.databinding.FragmentGiftListBinding
import com.yatochk.wishlistapp.domain.GetUserWishListUseCase
import com.yatochk.wishlistapp.domain.RemoveUserGiftUseCase
import com.yatochk.wishlistapp.ui.base.GiftsFragment
import com.yatochk.wishlistapp.ui.user.add.AddGiftFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserGiftsFragment : GiftsFragment<FragmentGiftListBinding>() {

    @Inject
    lateinit var getUserWishListUseCase: GetUserWishListUseCase

    @Inject
    lateinit var removeUserGiftUseCase: RemoveUserGiftUseCase

    private val adapterUser: UserGiftAdapter by lazy {
        UserGiftAdapter(layoutInflater, ::onGiftLinkClick, ::onGiftDeleteClick)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGiftListBinding {
        return FragmentGiftListBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserWishListUseCase.get().observe(viewLifecycleOwner) {
            adapterUser.submitList(it)
        }
        binding?.apply {
            setupRecycler()
            buttonAddGift.setOnClickListener {
                onClickAddGift()
            }
        }
    }

    private fun onClickAddGift() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment, AddGiftFragment())
            .commitAllowingStateLoss()
    }

    private fun onGiftDeleteClick(gift: Gift) {
        removeUserGiftUseCase.remove(gift)
    }

    private fun FragmentGiftListBinding.setupRecycler() {
        recyclerGifts.adapter = adapterUser
        recyclerGifts.layoutManager = LinearLayoutManager(context)
    }

}