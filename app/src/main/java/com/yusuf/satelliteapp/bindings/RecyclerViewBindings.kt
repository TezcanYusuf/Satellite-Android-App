package com.yusuf.satelliteapp.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.satelliteapp.R
import com.yusuf.satelliteapp.Utils.orZero
import com.yusuf.satelliteapp.common.SpaceItemDecoration
import com.yusuf.satelliteapp.extensions.color
import com.yusuf.satelliteapp.extensions.dimenToPx
import com.yusuf.satelliteapp.extensions.setDivider

@BindingAdapter(
    value = [
        "spacePaddingStart",
        "spacePaddingTop",
        "spacePaddingEnd",
        "spacePaddingBottom"
    ],
    requireAll = false
)
fun RecyclerView.addSpaceDivider(
    spacePaddingStart: Float? = 0.0f,
    spacePaddingTop: Float? = 0.0f,
    spacePaddingEnd: Float? = 0.0f,
    spacePaddingBottom: Float? = 0.0f,
) {
    addItemDecoration(
        SpaceItemDecoration(
            spacePaddingStart?.toInt().orZero(),
            spacePaddingTop?.toInt().orZero(),
            spacePaddingEnd?.toInt().orZero(),
            spacePaddingBottom?.toInt().orZero(),
        )
    )
}

@BindingAdapter(
    value = [
        "dividerColor",
        "dividerOrientation",
        "dividerPaddingStart",
        "dividerPaddingTop",
        "dividerPaddingEnd",
        "dividerPaddingBottom",
        "dividerThickness",
        "dividerLastItem"
    ],
    requireAll = false
)
fun RecyclerView.setDividerBinding(
    dividerColor: Int?,
    dividerOrientation: Int?,
    dividerPaddingStart: Float?,
    dividerPaddingTop: Float?,
    dividerPaddingEnd: Float?,
    dividerPaddingBottom: Float?,
    dividerThickness: Float?,
    dividerLastItem: Boolean?,
) {
    setDivider(
        color = dividerColor ?: color(R.color.black),
        orientation = dividerOrientation ?: DividerItemDecoration.VERTICAL,
        paddingLeft = dividerPaddingStart?.toInt().orZero(),
        paddingTop = dividerPaddingTop?.toInt().orZero(),
        paddingRight = dividerPaddingEnd?.toInt().orZero(),
        paddingBottom = dividerPaddingBottom?.toInt().orZero(),
        thickness = dividerThickness?.toInt() ?: dimenToPx(R.dimen.height_1),
        isLastItemDecorated = dividerLastItem ?: true,
    )
}
