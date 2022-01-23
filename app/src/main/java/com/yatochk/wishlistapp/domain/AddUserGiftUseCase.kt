package com.yatochk.wishlistapp.domain

import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.data.user.UserInfoRepository
import com.yatochk.wishlistapp.data.gift.WishListRepository
import javax.inject.Inject

class AddUserGiftUseCase @Inject constructor(
    private val wishListRepository: WishListRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun add(gift: Gift) {
        val userInfo = userInfoRepository.getUserInfo()
        wishListRepository.addGiftToWishList(userInfo.wishListName, gift)
    }

}