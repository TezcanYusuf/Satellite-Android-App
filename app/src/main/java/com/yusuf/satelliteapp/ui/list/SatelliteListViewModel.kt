package com.yusuf.satelliteapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.yusuf.satelliteapp.base.BaseViewModel
import com.yusuf.satelliteapp.models.SatelliteListModel

class SatelliteListViewModel: BaseViewModel() {

    private val _satelliteList = MutableLiveData<SatelliteListModel>()
    val satelliteList: LiveData<SatelliteListModel> get() = _satelliteList

    fun setSatelliteList(data: String) {
        val gson = Gson()
        _satelliteList.value = (gson.fromJson(data, SatelliteListModel::class.java))
    }
}