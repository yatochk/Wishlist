package com.yatochk.wishlistapp.domain

import com.yatochk.wishlist.common.utils.WISH_LIST_PREFIX
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlist.gifts.api.gift.data.GiftsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFriendWishListUseCase @Inject constructor(
    private val giftsRepository: GiftsRepository
) {

    fun get(friendName: String): Flow<List<Gift>> {
        return giftsRepository.getGiftsByName(WISH_LIST_PREFIX + friendName)
    }

}