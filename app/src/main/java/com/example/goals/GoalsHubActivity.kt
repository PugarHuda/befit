import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goals.Goal
import com.example.goals.GoalAdapter



class GoalsHubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_hub)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewGoals)

        // Contoh data
        val goals = listOf(
            Goal("HEALTHY FOOD", 1, 45, 100, R.drawable.ic_healthy_food),
            Goal("MINDFULNESS", 1, 45, 100, R.drawable.ic_mindfulness),
            Goal("SLEEP", 10, 12, 450, R.drawable.ic_sleep),
            Goal("WORKOUT", 10, 12, 450, R.drawable.ic_workout)
        )

        // Setup RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GoalAdapter(goals)
    }
}
