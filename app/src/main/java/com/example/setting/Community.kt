package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Community : AppCompatActivity() {

    private val postListMyPage = mutableListOf<Post>()
    private val postListForYou = listOf(
        Post(
            avatarResId = R.drawable.char2,
            username = "Jane Smith",
            postTime = "1 day ago",
            postText = "Tips produktivitas di akhir pekan?",
            likeCount = 12,
            commentCount = 4
        )
    )
    private val postListFriends = listOf(
        Post(
            avatarResId = R.drawable.char3,
            username = "Alex Brown",
            postTime = "3 days ago",
            postText = "Apakah ada yang punya rekomendasi buku tentang self-improvement?",
            likeCount = 8,
            commentCount = 2
        )
    )

    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        // Membaca data post yang baru dikirim dari CreatePostActivity
        val newPostText = intent.getStringExtra("newPost")
        newPostText?.let {
            // Jika ada post baru, tambahkan ke daftar "My Page"
            val newPost = Post(

                avatarResId = R.drawable.char1,  // Ganti dengan avatar yang sesuai
                username = "Your Name",  // Ganti dengan nama pengguna
                postTime = "Just now",
                postText = it,
                likeCount = 0,
                commentCount = 0
            )
            postListMyPage.add(0, newPost)  // Tambahkan pesan baru di atas

            // Menampilkan notifikasi berhasil
            Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()
        }

        // Setup RecyclerView dan Adapter
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter(postListMyPage)
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

        // Fungsi untuk tombol kembali
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, DailyTaskActivity::class.java)
            startActivity(intent) // Membuka halaman DailyTaskActivity
            finish() // Menutup aktivitas saat ini
        }

        // Fungsi untuk tombol friend
        val friendButton = findViewById<ImageButton>(R.id.friend)
        friendButton.setOnClickListener {
            val intent = Intent(this, friendActivity::class.java)
            startActivity(intent) // Membuka halaman FriendActivity
        }

        // Menangani klik pada FloatingActionButton
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            // Ketika FAB diklik, buka CreatePostActivity
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent) // Membuka CreatePostActivity
        }
    }

    // Metode untuk memperbarui adapter setelah ada data baru
    private fun updatePostList() {
        postAdapter.notifyDataSetChanged() // Memberi tahu adapter bahwa data telah berubah
    }
}
