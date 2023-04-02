package com.yusuf.satelliteapp.extensions

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat

fun Context.color(@ColorRes resource: Int): Int {
    return ContextCompat.getColor(this, resource)
}

fun Context.dimenToPx(@DimenRes dimen: Int): Int {
    return resources.dimenToPx(dimen)
}