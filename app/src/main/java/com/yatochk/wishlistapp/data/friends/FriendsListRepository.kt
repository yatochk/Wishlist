package com.yatochk.wishlistapp.data.friends

import com.google.firebase.firestore.FirebaseFirestore
import com.yatochk.wishlist.common.utils.WISH_LIST_COLLECTION
import javax.inject.Inject

class FriendsListRepository @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    fun getAllFriends(): FriendsListsLiveData {
        val collection = firestore.collection(WISH_LIST_COLLECTION)
        return FriendsListsLiveData(collection)
    }
}