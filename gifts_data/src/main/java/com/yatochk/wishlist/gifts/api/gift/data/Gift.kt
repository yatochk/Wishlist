package com.yatochk.wishlist.gifts.api.gift.data

import java.io.Serializable

data class Gift(
    val name: String,
    val description: String,
    val link: String,
    val imageUrl: String,
    val price: String
) : Serializable