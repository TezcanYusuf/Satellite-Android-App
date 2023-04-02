package com.yusuf.satelliteapp.ui.list

import android.util.Log
import com.yusuf.satelliteapp.R
import com.yusuf.satelliteapp.Utils
import com.yusuf.satelliteapp.base.BaseFragment
import com.yusuf.satelliteapp.databinding.FragmentSatelliteListBinding
import com.yusuf.satelliteapp.extensions.observe
import com.yusuf.satelliteapp.models.SatelliteListModel

class SatelliteListFragment : BaseFragment<SatelliteListViewModel, FragmentSatelliteListBinding>() {

    override fun viewModelClass() = SatelliteListViewModel::class.java

    override fun getResourceLayoutId() = R.layout.fragment_satellite_list

    override fun onInitDataBinding() {
        getSatelliteList()
        observe(viewModel.satelliteList, ::onSatelliteListChanged)
    }

    private fun getSatelliteList() {
        try {
            val jsonString = requireContext().assets.open(Utils.satelliteList).bufferedReader().use { it.readText() }
            viewModel.setSatelliteList(jsonString)
        } catch (e: Exception) {
            e.localizedMessage?.let { Log.e("Error Satellite List", it) }
        }
    }

    private fun onSatelliteListChanged(satelliteListModel: SatelliteListModel) {
        Log.e("dattaa", satelliteListModel.toString())

    }

}
