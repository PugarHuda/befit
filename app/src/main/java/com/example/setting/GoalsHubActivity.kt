package com.example.setting

import android.os.Bundle
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
        recyclerView.adapter = GoalAdapter(goals)
    }
}


