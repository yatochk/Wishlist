package com.yatochk.wishlistapp.data

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class WishListRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    companion object {
        private const val WISH_LIST_COLLECTION = "wishlists"
    }

    fun getWishList(name: String): WishListLiveData {
        val document = firestore.collection(WISH_LIST_COLLECTION)
            .document(name)
        return WishListLiveData(document)
    }

    fun addGiftToWishList(listName: String, gift: Gift) {
        firestore.collection(WISH_LIST_COLLECTION)
            .document(listName)
            .update(gift.name, gift.link)
    }

    fun removeGiftFromWishList(listName: String, giftName: String) {
        val update = hashMapOf<String, Any>(giftName to FieldValue.delete())
        firestore.collection(WISH_LIST_COLLECTION)
            .document(listName)
            .update(update)
    }

}