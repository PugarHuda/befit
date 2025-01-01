package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

class DailyTaskActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_task) // Pastikan file layout ini ada

        // Inisialisasi Firebase
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        // Mendapatkan nama pengguna dari Firebase
        val userId = auth.currentUser?.uid
        if (userId != null) {
            getUsernameFromDatabase(userId)
        }

        // Navigasi ke ChallengeActivity
        val challengeLink: TextView = findViewById(R.id.challenge)
        challengeLink.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }

        val settingLink: ImageView = findViewById(R.id.imageView4)
        settingLink.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val goalLink: ImageButton = findViewById(R.id.btGoal)
        goalLink.setOnClickListener {
            val intent = Intent(this, GoalsHubActivity::class.java)
            startActivity(intent)
        }

        val shopLink: ImageButton = findViewById(R.id.btShop)
        shopLink.setOnClickListener {
            Log.d("DailyTaskActivity", "Navigating to ShopActivity") // Log untuk memastikan klik terjadi
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

        val friendLink: ImageButton = findViewById(R.id.btFriend)
        friendLink.setOnClickListener {
            val intent = Intent(this, Community::class.java)
            startActivity(intent)
        }
    }

    // Fungsi untuk mengambil username dari database
    private fun getUsernameFromDatabase(userId: String) {
        val userRef = database.child("users").child(userId).child("username")

        userRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val username = snapshot.getValue(String::class.java)
                if (username != null) {
                    // Menampilkan nama pengguna di TextView
                    val welcomeTextView: TextView = findViewById(R.id.nama) // Ganti dengan ID TextView Anda
                    welcomeTextView.text = "Hello, $username!" // Menampilkan nama pengguna
                } else {
                    // Jika nama pengguna tidak ditemukan
                    Log.e("DailyTaskActivity", "Username not found in database")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("DailyTaskActivity", "Error fetching username: ${error.message}")
            }
        })
    }
}
