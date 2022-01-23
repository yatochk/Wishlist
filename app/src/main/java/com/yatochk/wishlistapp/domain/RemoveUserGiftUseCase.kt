package com.yatochk.wishlistapp.domain

import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.data.user.UserInfoRepository
import com.yatochk.wishlistapp.data.gift.WishListRepository
import javax.inject.Inject

class RemoveUserGiftUseCase @Inject constructor(
    private val wishListRepository: WishListRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun remove(gift: Gift) {
        val userInfo = userInfoRepository.getUserInfo()
        wishListRepository.removeGiftFromWishList(
            userInfo.wishListName,
            gift.name
        )
    }

}