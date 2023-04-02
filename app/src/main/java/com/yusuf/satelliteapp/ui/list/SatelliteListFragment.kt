package com.yusuf.satelliteapp.ui.list

import android.util.Log
import com.yusuf.satelliteapp.R
import com.yusuf.satelliteapp.Utils
import com.yusuf.satelliteapp.base.BaseFragment
import com.yusuf.satelliteapp.databinding.FragmentSatelliteListBinding
import com.yusuf.satelliteapp.extensions.observe
import com.yusuf.satelliteapp.models.SatelliteListModel
import com.yusuf.satelliteapp.ui.list.adapter.SatelliteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
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
        viewBinding.rvSatellite.adapter = SatelliteAdapter(satelliteListModel, viewModel)
    }

}
