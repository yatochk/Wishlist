package com.yatochk.wishlist.gifts.api.wishlists.data

import com.yatochk.wishlist.gifts.api.gift.data.Gift

data class WishList(
    val wishlistName: String,
    val userName: String,
    val gifts: List<Gift>
)