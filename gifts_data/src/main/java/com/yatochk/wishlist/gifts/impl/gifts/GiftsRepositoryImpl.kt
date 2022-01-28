package com.yatochk.wishlist.gifts.impl.gifts

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.yatochk.wishlist.common.utils.WISH_LIST_COLLECTION
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlist.gifts.api.gift.data.GiftsRepository
import com.yatochk.wishlist.gifts.impl.utils.toItemsFlow
import com.yatochk.wishlist.gifts.impl.wishlists.FirestoreWishListConverter
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GiftsRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val converter: FirestoreWishListConverter,
    private val gson: Gson
) : GiftsRepository {

    override fun getGiftsByName(name: String): Flow<List<Gift>> {
        return firestore.collection(WISH_LIST_COLLECTION).document(name)
            .toItemsFlow(converter::convertGifts)
    }

    override fun addGiftToWishList(listName: String, gift: Gift) {
        val giftJson = gson.toJson(gift)
        firestore.collection(WISH_LIST_COLLECTION)
            .document(listName)
            .update(gift.name, giftJson)
    }

    override fun removeGiftFromWishList(listName: String, giftName: String) {
        val update = hashMapOf<String, Any>(giftName to FieldValue.delete())
        firestore.collection(WISH_LIST_COLLECTION)
            .document(listName)
            .update(update)
    }
}