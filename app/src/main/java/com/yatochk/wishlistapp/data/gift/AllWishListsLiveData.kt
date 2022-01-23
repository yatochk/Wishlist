package com.yatochk.wishlistapp.data.gift

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.QuerySnapshot


class AllWishListsLiveData(
    private val collectionReference: CollectionReference
) : LiveData<List<WishList>>(), OnSuccessListener<QuerySnapshot?> {


    override fun onActive() {
        super.onActive()
        collectionReference.get().addOnSuccessListener(this)
    }

    override fun onSuccess(result: QuerySnapshot?) {
        result ?: return
        val wishLists = result.map { document ->
            WishList(
                document.id,
                document.data.map {
                    Gift(
                        it.key,
                        (it.value as? String).orEmpty()
                    )
                }
            )
        }
        postValue(wishLists)
    }
}