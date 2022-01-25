package com.yatochk.wishlistapp.ui.base

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.viewbinding.ViewBinding
import com.yatochk.wishlist.common.ui.BaseFragment

abstract class GiftsFragment<T : ViewBinding> : BaseFragment<T>() {

    protected fun onGiftLinkClick(url: String) {
        try {
            val webpage: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        } catch (throwable: Throwable) {
            Log.e("Open web link", throwable.localizedMessage, throwable)
        }
    }
}