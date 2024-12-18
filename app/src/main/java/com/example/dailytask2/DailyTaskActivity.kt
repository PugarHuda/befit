package com.example.dailytask2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DailyTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_task) // Pastikan file layout ini ada

        // Menyiapkan data untuk RecyclerView
        val navbarItems = listOf(
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_target, "Home"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_home, "Stats"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_shop, "Tasks"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_friends, "Settings")
        )


        // Menyambungkan RecyclerView dengan Adapter
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView) // Pastikan id ini sesuai dengan RecyclerView di layout
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = RecyclerViewAdapter(navbarItems)
        recyclerView.adapter = adapter

        // Navigasi ke ChallengeActivity
        val challengeLink: TextView = findViewById(R.id.challenge)
        challengeLink.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }
    }
}
