package com.yatochk.wishlistapp.domain

import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlist.gifts.api.gift.data.GiftsRepository
import com.yatochk.wishlistapp.login.api.data.UserInfoRepository
import javax.inject.Inject

class RemoveUserGiftUseCase @Inject constructor(
    private val giftsRepository: GiftsRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun remove(gift: Gift) {
        val userInfo = userInfoRepository.userInfo
        userInfo ?: return
        giftsRepository.removeGiftFromWishList(
            userInfo.wishListName,
            gift.name
        )
    }

}