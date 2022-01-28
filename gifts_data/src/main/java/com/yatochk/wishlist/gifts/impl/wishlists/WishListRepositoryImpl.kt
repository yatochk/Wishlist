package com.yatochk.wishlist.gifts.impl.wishlists

import com.google.firebase.firestore.FirebaseFirestore
import com.yatochk.wishlist.common.utils.WISH_LIST_COLLECTION
import com.yatochk.wishlist.gifts.api.wishlists.data.WishList
import com.yatochk.wishlist.gifts.api.wishlists.data.WishListRepository
import com.yatochk.wishlist.gifts.impl.utils.toFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class WishListRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val converter: FirestoreWishListConverter
) : WishListRepository {

    override fun getAllWishLists(): Flow<List<WishList>> {
        return firestore.collection(WISH_LIST_COLLECTION).toFlow(converter::convertCollection)
    }
}