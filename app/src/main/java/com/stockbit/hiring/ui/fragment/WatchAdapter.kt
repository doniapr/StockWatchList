package com.stockbit.hiring.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.hiring.databinding.ItemWatchListBinding
import com.stockbit.model.domain.Data

class WatchAdapter : RecyclerView.Adapter<WatchAdapter.WatchViewHolder>() {
    val dataList = ArrayList<Data>()

    fun setData(data: List<Data>?) {
        if (data == null) return
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchViewHolder {
        val view = ItemWatchListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return WatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: WatchViewHolder, position: Int) {
        holder.bindItem(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    class WatchViewHolder(private val binding: ItemWatchListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(watch: Data){
            binding.tvName.text = watch.coinInfo.name
            binding.tvFullname.text = watch.coinInfo.fullname
            binding.tvPrice.text = watch.display.idr.price
            binding.tvDiff.text = watch.display.idr.change24Hour

        }
    }
}