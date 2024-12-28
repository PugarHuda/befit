package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_shop)

        val itemList = listOf(
            DataClassShop("Item 1", R.drawable.char1, 10),
            DataClassShop("Item 2", R.drawable.char2, 12),
            DataClassShop("Item 3", R.drawable.char3, 8)
        )

        // Konfigurasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.ShopList)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 kolom
        recyclerView.adapter = ShopAdapter(itemList)

        // Tambahkan fungsi untuk tombol kembali
        val backButton = findViewById<ImageView>(R.id.ic_back) // Pastikan ID sesuai di XML
        backButton.setOnClickListener {
            finish() // Menutup ShopActivity dan kembali ke halaman sebelumnya
        }
    }
}
