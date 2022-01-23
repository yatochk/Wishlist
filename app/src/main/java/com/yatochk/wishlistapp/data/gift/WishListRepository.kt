package com.yatochk.wishlistapp.data.gift

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.yatochk.wishlistapp.utils.WISH_LIST_COLLECTION
import javax.inject.Inject

class WishListRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    fun getAllWishLists(): AllWishListsLiveData {
        val collection = firestore.collection(WISH_LIST_COLLECTION)
        return AllWishListsLiveData(collection)
    }

    fun getWishListByName(name: String): WishListLiveData {
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