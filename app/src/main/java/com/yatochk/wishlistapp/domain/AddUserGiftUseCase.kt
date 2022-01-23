package com.yatochk.wishlistapp.domain

import com.yatochk.wishlistapp.data.Gift
import com.yatochk.wishlistapp.data.UserInfoRepository
import com.yatochk.wishlistapp.data.WishListRepository
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