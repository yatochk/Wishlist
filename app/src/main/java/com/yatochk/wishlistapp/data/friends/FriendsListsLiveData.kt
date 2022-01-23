package com.yatochk.wishlistapp.data.friends

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot
import com.yatochk.wishlistapp.utils.WISH_LIST_PREFIX


class FriendsListsLiveData(
    private val collectionReference: CollectionReference
) : LiveData<List<Friend>>(), OnSuccessListener<QuerySnapshot?> {

    override fun onActive() {
        super.onActive()
        collectionReference.get().addOnSuccessListener(this)
    }

    override fun onSuccess(result: QuerySnapshot?) {
        result ?: return
        val wishLists = result.map { document ->
            Friend(
                document.id.removePrefix(WISH_LIST_PREFIX),
                document.data.count()
            )
        }
        postValue(wishLists)
    }
}