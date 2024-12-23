package com.example.setting

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class GoalsDetailActivity : AppCompatActivity() {
    private var isTasksExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_detail)

        // Find views
        val tasksHeader = findViewById<LinearLayout>(R.id.tasks_header)
        val tasksList = findViewById<LinearLayout>(R.id.tasks_list)
        val toggleIcon = findViewById<ImageView>(R.id.tasks_toggle_icon)

        // Handle click to toggle expand/collapse
        tasksHeader.setOnClickListener {
            isTasksExpanded = !isTasksExpanded
            if (isTasksExpanded) {
                tasksList.visibility = View.VISIBLE
                toggleIcon.setImageResource(R.drawable.arrow_right) // Replace with collapse icon
            } else {
                tasksList.visibility = View.GONE
                toggleIcon.setImageResource(R.drawable.arrow_back) // Replace with expand icon
            }
        }


    }
}
