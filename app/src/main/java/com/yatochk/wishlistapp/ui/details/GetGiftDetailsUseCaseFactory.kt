package com.yatochk.wishlistapp.ui.details

import com.yatochk.wishlist.gifts.api.gift.data.Gift
import javax.inject.Inject

class GetGiftDetailsUseCaseFactory @Inject constructor() {

    fun create(gift: Gift?): GetGiftDetailsUseCase {
        return GetGiftDetailsUseCase(gift)
    }

}