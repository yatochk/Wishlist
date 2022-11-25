package com.yatochk.wishlist.common.utils

import android.content.Context
import android.util.DisplayMetrics


fun Context.dpToPixel(dp: Float): Int {
    val rel = resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT
    return (dp * rel).toInt()
}
