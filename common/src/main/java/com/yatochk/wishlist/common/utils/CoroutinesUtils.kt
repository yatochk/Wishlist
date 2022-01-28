package com.yatochk.wishlist.common.utils

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun Fragment.lifecycleLaunch(
    context: CoroutineContext = CoroutineExceptionHandler { _, throwable ->
        Log.e(this::class.java.simpleName, throwable.localizedMessage, throwable)
    },
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return viewLifecycleOwner.lifecycleScope.launch(context, start, block)
}