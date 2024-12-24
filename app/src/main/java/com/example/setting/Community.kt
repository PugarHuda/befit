package com.example.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout

class Community : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        // Data nyata untuk komunitas
        val postListMyPage = listOf(
            Post(
                avatarResId = R.drawable.char1,
                username = "John Doe",
                postTime = "2 hours ago",
                postText = "Bagaimana cara mengenali gejala depresi pada diri sendiri atau orang lain?",
                likeCount = 5,
                commentCount = 3
            )
        )
        val postListForYou = listOf(
            Post(
                avatarResId = R.drawable.char2,
                username = "Jane Smith",
                postTime = "1 day ago",
                postText = "Tips produktivitas di akhir pekan?",
                likeCount = 12,
                commentCount = 4
            )
        )
        val postListFriends = listOf(
            Post(
                avatarResId = R.drawable.char3,
                username = "Alex Brown",
                postTime = "3 days ago",
                postText = "Apakah ada yang punya rekomendasi buku tentang self-improvement?",
                likeCount = 8,
                commentCount = 2
            )
        )

        // RecyclerView setup
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val postAdapter = PostAdapter(postListMyPage)
        recyclerView.adapter = postAdapter

        // TabLayout setup
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> postAdapter.updateData(postListMyPage) // My Page
                    1 -> postAdapter.updateData(postListForYou) // For You
                    2 -> postAdapter.updateData(postListFriends) // Friends
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

}
