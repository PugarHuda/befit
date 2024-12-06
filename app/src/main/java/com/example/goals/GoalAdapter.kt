import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GoalAdapter(private val goalList: List<Goal>) :
    RecyclerView.Adapter<GoalAdapter.GoalViewHolder>() {

    inner class GoalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvGoalTitle)
        val level: TextView = itemView.findViewById(R.id.tvGoalLevel)
        val progressBar: ProgressBar = itemView.findViewById(R.id.pbGoalProgress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_goal, parent, false)
        return GoalViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = goalList[position]
        holder.title.text = goal.title
        holder.level.text = "Level ${goal.level}"
        holder.progressBar.max = goal.maxProgress
        holder.progressBar.progress = goal.progress
    }

    override fun getItemCount(): Int = goalList.size
}

