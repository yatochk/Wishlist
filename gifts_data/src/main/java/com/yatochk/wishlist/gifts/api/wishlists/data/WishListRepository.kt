package com.yatochk.wishlist.gifts.api.wishlists.data

import kotlinx.coroutines.flow.Flow

interface WishListRepository {
    fun getAllWishLists(): Flow<List<WishList>>
}