package com.example.dailytask2



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_task)

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView)

        // Daftar data NavbarItem
        val navbarItems = listOf(
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_target, "Home"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_home, "Stats"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_shop, "Tasks"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_friends, "Settings")
        )

        // Menambahkan LayoutManager untuk menata item secara vertikal
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menambahkan Adapter dan menghubungkannya dengan data
        recyclerViewAdapter = RecyclerViewAdapter(navbarItems)
        recyclerView.adapter = recyclerViewAdapter
    }
}
