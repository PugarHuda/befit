package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class ChallengeActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenge) // Pastikan file layout ini ada

        // Inisialisasi Firebase Realtime Database
        database = FirebaseDatabase.getInstance().reference

        // Mendapatkan nama pengguna terbaru dari Realtime Database
        getLatestUsernameFromDatabase()

        // Navigasi ke DailyTaskActivity
        val dailyTaskLink: TextView = findViewById(R.id.dailyTask)
        dailyTaskLink.setOnClickListener {
            val intent = Intent(this, DailyTaskActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke AddChallengeActivity
        val addChallengeLink: Button = findViewById(R.id.buttonAdd)
        addChallengeLink.setOnClickListener {
            val intent = Intent(this, AddChallengeActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Settings
        val settingLink: ImageView = findViewById(R.id.imageView4)
        settingLink.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk mengambil nama pengguna terbaru dari database
    private fun getLatestUsernameFromDatabase() {
        val userRef = database.child("users") // Mengacu pada node "users"

        userRef.orderByKey().limitToLast(1).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val username = userSnapshot.child("username").getValue(String::class.java)
                        if (username != null) {
                            // Menampilkan nama pengguna di TextView
                            val welcomeTextView: TextView = findViewById(R.id.nama) // Ganti dengan ID TextView Anda
                            welcomeTextView.text = "$username" // Menampilkan nama pengguna
                        } else {
                            Log.e("ChallengeActivity", "Username field not found!")
                        }
                    }
                } else {
                    Log.e("ChallengeActivity", "No users found in database!")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ChallengeActivity", "Error fetching username: ${error.message}")
            }
        })
    }
}
