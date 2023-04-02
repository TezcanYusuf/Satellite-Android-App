package com.yusuf.satelliteapp.extensions

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.yusuf.satelliteapp.R

fun RecyclerView.setDivider(
    color: Int? = color(R.color.black),
    orientation: Int = DividerItemDecoration.VERTICAL,
    paddingLeft: Int = 0,
    paddingTop: Int = 0,
    paddingRight: Int = 0,
    paddingBottom: Int = 0,
    thickness: Int = 0,
    isLastItemDecorated: Boolean = true,
) {

    val divider = MaterialDividerItemDecoration(context, orientation)
    divider.isLastItemDecorated = isLastItemDecorated
    divider.dividerColor = color ?: color(R.color.black)
    divider.dividerInsetStart =
        if (orientation == DividerItemDecoration.VERTICAL) paddingLeft else paddingTop
    divider.dividerInsetEnd =
        if (orientation == DividerItemDecoration.VERTICAL) paddingRight else paddingBottom
    divider.dividerThickness = thickness
    addItemDecoration(divider)
}
