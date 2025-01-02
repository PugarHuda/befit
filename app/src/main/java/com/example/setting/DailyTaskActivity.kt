package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class DailyTaskActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_task) // Pastikan file layout ini ada

        // Inisialisasi Firebase Realtime Database
        database = FirebaseDatabase.getInstance().reference

        // Mendapatkan nama pengguna terbaru dari Realtime Database
        getLatestUsernameFromDatabase()

        // Navigasi ke ChallengeActivity
        val challengeLink: TextView = findViewById(R.id.challenge)
        challengeLink.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Settings
        val settingLink: ImageView = findViewById(R.id.imageView4)
        settingLink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Goals Hub
        val goalLink: ImageButton = findViewById(R.id.btGoal)
        goalLink.setOnClickListener {
            val intent = Intent(this, GoalsHubActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke ShopActivity
        val shopLink: ImageButton = findViewById(R.id.btShop)
        shopLink.setOnClickListener {
            Log.d("DailyTaskActivity", "Navigating to ShopActivity") // Log untuk memastikan klik terjadi
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Community
        val friendLink: ImageButton = findViewById(R.id.btFriend)
        friendLink.setOnClickListener {
            val intent = Intent(this, Community::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk mengambil nama pengguna terbaru berdasarkan data yang terakhir dimasukkan
    private fun getLatestUsernameFromDatabase() {
        val userRef = database.child("users") // Mengacu pada node "users"

        // Urutkan berdasarkan key dan ambil data terakhir
        userRef.orderByKey().limitToLast(1).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // Ambil data user yang terakhir
                    for (userSnapshot in snapshot.children) {
                        val username = userSnapshot.child("username").getValue(String::class.java)
                        if (username != null) {
                            // Menampilkan username yang terakhir
                            val welcomeTextView: TextView = findViewById(R.id.nama)
                            welcomeTextView.text = "$username" // Menampilkan username
                        } else {
                            Log.e("DailyTaskActivity", "Username field not found!")
                        }
                    }
                } else {
                    Log.e("DailyTaskActivity", "No users found in database!")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("DailyTaskActivity", "Error fetching username: ${error.message}")
            }
        })
    }
}
