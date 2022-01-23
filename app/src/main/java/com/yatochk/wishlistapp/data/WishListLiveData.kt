package com.yatochk.wishlistapp.data

import androidx.lifecycle.LiveData
import com.google.firebase.firestore.*


class WishListLiveData(
    private val documentReference: DocumentReference
) : LiveData<List<Gift?>?>(), EventListener<DocumentSnapshot?> {

    private var listenerRegistration = ListenerRegistration {}

    override fun onActive() {
        super.onActive()
        listenerRegistration = documentReference.addSnapshotListener(this)
    }

    override fun onInactive() {
        super.onInactive()
        listenerRegistration.remove()
    }

    override fun onEvent(
        documentSnapshot: DocumentSnapshot?,
        e: FirebaseFirestoreException?
    ) {
        if (documentSnapshot != null && documentSnapshot.exists()) {
            val gifts = documentSnapshot.data?.map {
                Gift(it.key, (it.value as? String).orEmpty())
            }
            postValue(gifts)
        }
    }
}