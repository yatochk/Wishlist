package com.yatochk.wishlistapp.domain

import androidx.lifecycle.LiveData
import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.data.gift.WishListRepository
import com.yatochk.wishlistapp.data.user.UserInfoRepository
import javax.inject.Inject

class GetUserWishListUseCase @Inject constructor(
    private val wishListRepository: WishListRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun get(): LiveData<List<Gift>> {
        val userInfo = userInfoRepository.getUserInfo()
        return wishListRepository.getWishListByName(userInfo.wishListName)
    }

}