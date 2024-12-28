package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GoalsHubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_hub)

        // Dummy data untuk goals
        val goals = listOf(
            Goal(R.drawable.meal, "Healthy Food", "LVL 1 45/100", 45, 100),
            Goal(R.drawable.yoga, "Mindfulness", "LVL 1 45/100", 45, 100),
            Goal(R.drawable.sleep, "Sleep", "LVL 10 12/450", 12, 450),
            Goal(R.drawable.walk, "Workout", "LVL 10 12/450", 12, 450)
        )

        // Referensi ke RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.goalsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GoalAdapter(goals) { goal ->
            // Intent ke GoalsDetailActivity jika item diklik
            if (goal.title == "Healthy Food") {
                val intent = Intent(this, GoalsDetailActivity::class.java)
                intent.putExtra("GOAL_TITLE", goal.title)
                startActivity(intent)
            }
        }

        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, DailyTaskActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
