package com.example.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GoalAdapter(
    private val goals: List<Goal>, // Daftar goals
    private val onItemClickListener: (Goal) -> Unit // Listener untuk klik item
) : RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = goals[position]
        holder.bind(goal)
    }

    override fun getItemCount() = goals.size

    inner class GoalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.goalIcon)
        val title: TextView = view.findViewById(R.id.goalTitle)
        val progressBar: ProgressBar = view.findViewById(R.id.goalProgressBar)

        // Mengisi data goal ke dalam view
        fun bind(goal: Goal) {
            icon.setImageResource(goal.icon)
            title.text = goal.title
            progressBar.max = goal.max
            progressBar.progress = goal.current

            // Menangani klik pada item
            itemView.setOnClickListener {
                onItemClickListener(goal)
            }
        }
    }
}
