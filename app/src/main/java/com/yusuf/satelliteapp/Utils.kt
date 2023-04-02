package com.yusuf.satelliteapp

object Utils {

    const val satelliteList = "satellite_list.json"

    fun Int?.orZero(): Int = this ?: 0

}