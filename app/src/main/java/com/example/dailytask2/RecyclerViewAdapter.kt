package com.example.dailytask2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val itemList: List<NavbarItem>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // Data model untuk tiap item
    data class NavbarItem(val icon: Int, val label: String)

    // ViewHolder untuk menampilkan layout item navbar
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Deklarasikan ImageView untuk setiap ikon
        val homeIcon: ImageView = itemView.findViewById(R.id.homeIcon)
        val statsIcon: ImageView = itemView.findViewById(R.id.statsIcon)
        val tasksIcon: ImageView = itemView.findViewById(R.id.tasksIcon)
        val settingsIcon: ImageView = itemView.findViewById(R.id.settingsIcon)
    }

    // Membuat ViewHolder dan menghubungkan layout item dengan item di RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_navbar, parent, false)
        return ViewHolder(itemView)
    }

    // Mengikat data ke dalam item layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        // Pastikan setiap ikon mendapatkan gambar yang sesuai
        when (position) {
            0 -> {
                holder.homeIcon.setImageResource(item.icon)
            }
            1 -> {
                holder.statsIcon.setImageResource(item.icon)
            }
            2 -> {
                holder.tasksIcon.setImageResource(item.icon)
            }
            3 -> {
                holder.settingsIcon.setImageResource(item.icon)
            }
        }

        // Mengatur label
    }

    // Menghitung jumlah item
    override fun getItemCount(): Int {
        return itemList.size
    }
}
