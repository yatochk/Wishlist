package com.yatochk.wishlist.gifts.impl.utils

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

internal fun <T> CollectionReference.toFlow(converter: (QuerySnapshot) -> T): Flow<T> {
    return callbackFlow {
        val subscription = addSnapshotListener { value, error ->
            when {
                value != null -> {
                    trySend(converter(value))
                }
                error != null -> {
                    close(error)
                }
            }
        }
        awaitClose { subscription.remove() }
    }
}

internal fun <T> DocumentReference.toFlow(converter: (DocumentSnapshot) -> T): Flow<T> {
    return callbackFlow {
        val subscription = addSnapshotListener { value, error ->
            when {
                value != null -> {
                    trySend(converter(value))
                }
                error != null -> {
                    close(error)
                }
            }
        }
        awaitClose { subscription.remove() }
    }
}

internal fun <T> DocumentReference.toItemsFlow(converter: (Map<String, Any>?) -> T): Flow<T> {
    return callbackFlow {
        val subscription = addSnapshotListener { value, error ->
            when {
                value != null -> {
                    trySend(converter(value.data))
                }
                error != null -> {
                    close(error)
                }
            }
        }
        awaitClose { subscription.remove() }
    }
}