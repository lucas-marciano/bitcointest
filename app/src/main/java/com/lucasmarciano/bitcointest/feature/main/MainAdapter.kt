package com.lucasmarciano.bitcointest.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasmarciano.bitcointest.R
import com.lucasmarciano.bitcointest.data.model.Transactions

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    var data: List<Transactions> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_list,
            parent,
            false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun render(item: Transactions) {
        }
    }
}