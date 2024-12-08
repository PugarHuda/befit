package com.example.dailytask2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DailyTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.daily_task) // pastikan layout dengan nama ini ada

        val challengeLink: TextView = findViewById(R.id.challenge)

        challengeLink.setOnClickListener{
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
    }



    }



}
