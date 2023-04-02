package com.yusuf.satelliteapp.ui.list.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.satelliteapp.databinding.ItemSatelliteBinding
import com.yusuf.satelliteapp.models.SatelliteListModelItem
import com.yusuf.satelliteapp.ui.list.SatelliteListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

class SatelliteAdapter(
    private var list: ArrayList<SatelliteListModelItem>,
    private val viewModel: SatelliteListViewModel
) :
    RecyclerView.Adapter<SatelliteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSatelliteBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    inner class ViewHolder(
        private val binding: ItemSatelliteBinding,
        private val viewModel: SatelliteListViewModel
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SatelliteListModelItem) {
            binding.satellite = item
            binding.satelliteItem.setOnClickListener {
                viewModel.satelliteListClick(item)
            }
            binding.executePendingBindings()
        }
    }

    fun setItems(items: List<SatelliteListModelItem>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }
}