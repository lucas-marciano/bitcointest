package com.lucasmarciano.bitcointest.feature.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.lucasmarciano.bitcointest.R
import com.lucasmarciano.bitcointest.base.extensions.convertTimestampToDate
import com.lucasmarciano.bitcointest.base.extensions.toPercent
import com.lucasmarciano.bitcointest.data.model.Transactions
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private lateinit var context: Context

    var data: List<Transactions> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(data[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun render(item: Transactions) {
            itemView.tvData.text = item.data
            itemView.tvValue.text = item.value.toPercent()
            itemView.tvDifference.text = item.difference.toPercent()

            if(item.difference > 0) {
                itemView.ivIndicator.setImageResource(R.drawable.ic_up)
            } else {
                itemView.ivIndicator.setImageResource(R.drawable.ic_down)
            }
        }
    }
}