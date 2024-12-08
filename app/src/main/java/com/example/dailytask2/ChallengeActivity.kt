package com.example.dailytask2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChallengeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.challenge) // pastikan layout dengan nama ini ada

        val dailyTaskLink: TextView = findViewById(R.id.dailyTask)
        val addChallengeLink : Button = findViewById(R.id.buttonAdd)

        dailyTaskLink.setOnClickListener{
            val intent = Intent(this, DailyTaskActivity::class.java)
            startActivity(intent)
        }

        addChallengeLink.setOnClickListener{
            val intent = Intent(this, AddChallengeActivity::class.java)
            startActivity(intent)
        }


    }



}
