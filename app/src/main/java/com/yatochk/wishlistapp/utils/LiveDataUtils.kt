package com.yatochk.wishlistapp.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

fun <T, R> LiveData<T>.map(mapper: (T) -> R): LiveData<R> {
    return Transformations.map(this) {
        mapper(it)
    }
}
