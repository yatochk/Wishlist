package com.yatochk.wishlistapp.domain

import com.yatochk.wishlistapp.data.Gift
import com.yatochk.wishlistapp.data.UserInfoRepository
import com.yatochk.wishlistapp.data.WishListRepository
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