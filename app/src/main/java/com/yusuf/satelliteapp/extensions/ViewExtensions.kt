package com.yusuf.satelliteapp.extensions

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes

fun View.color(@ColorRes resource: Int): Int {
    return context.color(resource)
}

fun View.dimenToPx(@DimenRes dimen: Int): Int {
    return context.dimenToPx(dimen)
}
