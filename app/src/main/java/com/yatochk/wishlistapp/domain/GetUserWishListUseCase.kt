package com.yatochk.wishlistapp.domain

import com.yatochk.wishlistapp.data.UserInfoRepository
import com.yatochk.wishlistapp.data.WishListLiveData
import com.yatochk.wishlistapp.data.WishListRepository
import javax.inject.Inject

class GetUserWishListUseCase @Inject constructor(
    private val wishListRepository: WishListRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun get(): WishListLiveData {
        val userInfo = userInfoRepository.getUserInfo()
        return wishListRepository.getWishList(userInfo.wishListName)
    }

}