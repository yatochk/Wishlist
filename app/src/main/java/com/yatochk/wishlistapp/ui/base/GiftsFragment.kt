package com.yatochk.wishlistapp.ui.base

import androidx.viewbinding.ViewBinding
import com.yatochk.wishlist.common.ui.BaseFragment
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.ui.details.GiftDetailsActivity

abstract class GiftsFragment<T : ViewBinding> : BaseFragment<T>() {

    protected fun onGiftClick(gift: Gift) {
        startActivity(GiftDetailsActivity.newIntent(requireContext(), gift))
    }
}