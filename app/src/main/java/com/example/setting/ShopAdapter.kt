package com.example.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ShopAdapter(private val itemList: List<DataClassShop>) :
    RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    // ViewHolder untuk setiap item
    class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.findViewById(R.id.characterName)
        val characterImage: ImageView = itemView.findViewById(R.id.characterImage)
        val coinText: TextView = itemView.findViewById(R.id.coinText) // Perbaiki ID ini
        val buyButton: Button = itemView.findViewById(R.id.buyButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop, parent, false)
        return ShopViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = itemList[position]

        // Set data untuk setiap item
        holder.characterName.text = item.name
        holder.characterImage.setImageResource(item.imageResId) // Gambar karakter
        holder.coinText.text = "Coins: ${item.coins}"

        // Aksi pada tombol "Buy"
        holder.buyButton.setOnClickListener {
            // Tambahkan logika untuk pembelian item
            println("${item.name} dibeli dengan harga ${item.coins} koin!")
        }
    }

    override fun getItemCount(): Int = itemList.size
}
