package com.yatochk.wishlist.gifts.impl.wishlists

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.yatochk.wishlist.common.utils.WISH_LIST_PREFIX
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlist.gifts.api.wishlists.data.WishList
import javax.inject.Inject

class FirestoreWishListConverter @Inject constructor() {

    fun convertCollection(querySnapshot: QuerySnapshot): List<WishList> {
        return querySnapshot.map { convertDocument(it) }
    }

    private fun convertDocument(document: DocumentSnapshot): WishList {
        return WishList(
            document.id,
            document.id.removePrefix(WISH_LIST_PREFIX),
            convertGifts(document.data)
        )
    }

    fun convertGifts(gifts: Map<String, Any>?): List<Gift> {
        gifts ?: return emptyList()
        return gifts.map {
            Gift(it.key, (it.value as? String).orEmpty())
        }
    }

}