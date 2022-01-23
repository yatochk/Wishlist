package com.yatochk.wishlistapp.domain

import androidx.lifecycle.LiveData
import com.yatochk.wishlistapp.data.gift.Gift
import com.yatochk.wishlistapp.data.gift.WishListRepository
import com.yatochk.wishlistapp.utils.WISH_LIST_PREFIX
import javax.inject.Inject

class GetFriendWishListUseCase @Inject constructor(
    private val wishListRepository: WishListRepository
) {

    fun get(friendName: String): LiveData<List<Gift>> {
        return wishListRepository.getWishListByName(WISH_LIST_PREFIX + friendName)
    }

}