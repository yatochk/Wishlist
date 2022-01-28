package com.yatochk.wishlist.common.utils

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.showFragment(@IdRes id: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(id, fragment)
        .commitAllowingStateLoss()
}

fun Fragment.showFragment(@IdRes id: Int, fragment: Fragment) {
    childFragmentManager.beginTransaction()
        .replace(id, fragment)
        .commitAllowingStateLoss()
}