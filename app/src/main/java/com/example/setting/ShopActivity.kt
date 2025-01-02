package com.example.setting

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ShopActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private val itemList = mutableListOf<DataClassShop>()
    private lateinit var shopAdapter: ShopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        // Inisialisasi Firebase
        database = FirebaseDatabase.getInstance().reference

        // Inisialisasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.ShopList)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Inisialisasi Adapter
        shopAdapter = ShopAdapter(itemList)
        recyclerView.adapter = shopAdapter

        // Ambil data dari Firebase
        fetchShopItems()

        // Fungsi untuk tombol kembali
        findViewById<ImageView>(R.id.ic_back).setOnClickListener {
            finish() // Menutup aktivitas ini
        }
    }

    private fun fetchShopItems() {
        database.child("shopItems").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                itemList.clear() // Bersihkan data lama
                for (dataSnapshot in snapshot.children) {
                    val item = dataSnapshot.getValue(DataClassShop::class.java)
                    if (item != null) {
                        itemList.add(item)
                    }
                }
                shopAdapter.notifyDataSetChanged() // Beritahu adapter bahwa data berubah
            }

            override fun onCancelled(error: DatabaseError) {
                // Tangani error
                println("Database Error: ${error.message}")
            }
        })
    }
}