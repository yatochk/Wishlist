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
            Gift(
                name = it.key,
                description = "А тут у нас лежит очень длинное описание подарка, что угодно сюда напишем, лишь бы влезало нормально",
                link = (it.value as? String).orEmpty(),
                imageUrl = "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/ipad-pro-12-11-select-202104_GEO_RU_FMT_WHH?wid=2000&hei=2000&fmt=jpeg&qlt=80&.v=1617865134000"
            )
        }
    }

}