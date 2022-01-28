package com.yatochk.wishlist.gifts.api.gift.data

import kotlinx.coroutines.flow.Flow

interface GiftsRepository {
    fun getGiftsByName(name: String): Flow<List<Gift>>
    fun addGiftToWishList(listName: String, gift: Gift)
    fun removeGiftFromWishList(listName: String, giftName: String)
}