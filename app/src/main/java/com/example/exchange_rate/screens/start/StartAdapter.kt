package com.example.exchange_rate.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exchange_rate.databinding.ItemMoneyLayoutBinding
import com.example.exchange_rate.model.rateAlpha.RateAlpha

class StartAdapter: RecyclerView.Adapter<StartAdapter.ItemViewHolder>() {
    var listStart = emptyList<RateAlpha>()

    class ItemViewHolder(val binding: ItemMoneyLayoutBinding) :RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = ItemMoneyLayoutBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  listStart.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.binding.itemName.text = listStart[position].data!![position].currencyCode
        holder.binding.itemBuy.text = listStart[position].data!![position].rateByClientType!![position].ratesByType!![position].lastActualRate.buy.originalValue.toString()
        holder.binding.itemSale.text = listStart[position].data!![position].rateByClientType!![position].ratesByType!![position].lastActualRate.sell.originalValue.toString()

    }

//    @SuppressLint("notifyDataSetChanged")
////    fun setList(list: RateAlpha?) {
////        listStart = list
////        notifyDataSetChanged()
////    }
}