package com.example.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GoalAdapter(private val goals: List<Goal>) :
    RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = goals[position]
        holder.icon.setImageResource(goal.icon)
        holder.title.text = goal.title
        holder.progressText.text = goal.progress
        holder.progressBar.max = goal.max
        holder.progressBar.progress = goal.current
    }

    override fun getItemCount() = goals.size

    class GoalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.goalIcon)
        val title: TextView = view.findViewById(R.id.goalTitle)
        val progressText: TextView = view.findViewById(R.id.goalProgressText)
        val progressBar: ProgressBar = view.findViewById(R.id.goalProgressBar)
    }
}
