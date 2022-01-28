package com.yatochk.wishlistapp.domain

import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlist.gifts.api.gift.data.GiftsRepository
import com.yatochk.wishlistapp.login.api.data.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserWishListUseCase @Inject constructor(
    private val giftsRepository: GiftsRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun get(): Flow<List<Gift>> {
        val wishListName = userInfoRepository.userInfo?.wishListName.orEmpty()
        return giftsRepository.getGiftsByName(wishListName)
    }

}