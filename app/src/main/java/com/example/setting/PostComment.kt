data class PostComment(
    val username: String,
    val time: String,
    val comment: String,
    val replies: List<PostComment> = listOf() // Balasan komentar, bisa kosong
)
