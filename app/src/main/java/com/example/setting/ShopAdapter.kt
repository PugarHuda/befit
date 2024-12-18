package com.example.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ShopAdapter(private val itemList: List<DataClassShop>) :
    RecyclerView.Adapter<ShopAdapter.ViewHolder>() {

    // ViewHolder untuk setiap item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.ShopList)
        val tvItemTitle: TextView = itemView.findViewById(R.id.ShopList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItemTitle.text = itemList[position].toString() // Set data item
    }

    override fun getItemCount(): Int = itemList.size
}
