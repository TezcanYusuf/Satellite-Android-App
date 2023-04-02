package com.yusuf.satelliteapp.ui.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.yusuf.satelliteapp.base.BaseViewModel
import com.yusuf.satelliteapp.models.SatelliteListModel
import com.yusuf.satelliteapp.models.SatelliteListModelItem

class SatelliteListViewModel: BaseViewModel() {

    private val _satelliteList = MutableLiveData<SatelliteListModel>()
    val satelliteList: LiveData<SatelliteListModel> get() = _satelliteList

    fun setSatelliteList(data: String) {
        val gson = Gson()
        _satelliteList.value = (gson.fromJson(data, SatelliteListModel::class.java))
    }

    fun satelliteListClick(satellite: SatelliteListModelItem) {
        Log.e("Satellite Item Go Detail", "$satellite ----")
    }
}