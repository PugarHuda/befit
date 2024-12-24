package com.example.setting


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DailyTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_task) // Pastikan file layout ini ada

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
            val intent = Intent(this, friendActivity::class.java)
            startActivity(intent)
        }


        }

}
