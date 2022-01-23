package com.yatochk.wishlistapp.ui.gift.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.Gift
import com.yatochk.wishlistapp.data.WishListRepository
import com.yatochk.wishlistapp.databinding.FragmentGiftAddBinding
import com.yatochk.wishlistapp.ui.BaseFragment
import com.yatochk.wishlistapp.ui.gift.list.GiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddGiftFragment : BaseFragment<FragmentGiftAddBinding>() {

    @Inject
    lateinit var repository: WishListRepository

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGiftAddBinding {
        return FragmentGiftAddBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.listenButton()
    }

    private fun FragmentGiftAddBinding.listenButton() {
        createGift.setOnClickListener {
            val gift = Gift(
                editTextName.text.toString(),
                editTextLink.text.toString()
            )
            repository.addGiftToWishList("wishlist-alexey", gift)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment, GiftsFragment())
                .commitAllowingStateLoss()
        }
    }

}