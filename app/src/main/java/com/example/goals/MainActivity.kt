class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals_hub)

        // Data dummy
        val goalList = listOf(
            Goal("Healthy Food", "1", 45, 100),
            Goal("Mindfulness", "1", 45, 100),
            Goal("Sleep", "10", 12, 450),
            Goal("Workout", "10", 12, 450)
        )

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewGoals)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GoalAdapter(goalList)
    }
}
