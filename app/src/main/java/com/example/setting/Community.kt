package com.example.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Comunity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        // Data nyata untuk komunitas
        val postList = listOf(
            Post(
                avatarResId = R.drawable.char1, // Pastikan gambar tersedia di drawable
                username = "John Doe",
                postTime = "2 hours ago",
                postText = "Bagaimana cara mengenali gejala depresi pada diri sendiri atau orang lain?",
                likeCount = 5,
                commentCount = 3
            ),
            Post(
                avatarResId = R.drawable.char2, // Gambar avatar lainnya
                username = "Jane Smith",
                postTime = "1 day ago",
                postText = "Tips produktivitas di akhir pekan?",
                likeCount = 12,
                commentCount = 4
            ),
            Post(
                avatarResId = R.drawable.char3, // Gambar avatar lainnya
                username = "Alex Brown",
                postTime = "3 days ago",
                postText = "Apakah ada yang punya rekomendasi buku tentang self-improvement?",
                likeCount = 8,
                commentCount = 2
            ),
            Post(
                avatarResId = R.drawable.char3, // Gambar avatar lainnya
                username = "Alex Brown",
                postTime = "3 days ago",
                postText = "Apakah ada yang punya rekomendasi buku tentang self-improvement?",
                likeCount = 8,
                commentCount = 2
            )
        )

        // RecyclerView setup
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView) // Ganti ID sesuai layout Anda
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PostAdapter(postList)
    }
}
