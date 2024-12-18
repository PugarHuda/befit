package com.example.setting

import android.os.Bundle
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

        val cardView = findViewById<CardView>(R.id.ShopList)

        // Tambahkan margin kanan
        val recyclerView = findViewById<RecyclerView>(R.id.ShopList)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 kolom
        recyclerView.adapter = ShopAdapter(itemList)
    }
}