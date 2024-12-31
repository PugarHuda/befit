package com.example.setting

data class Post(
    val avatarResId: Int,      // Resource ID untuk avatar
    val username: String,      // Nama pengguna
    val postTime: String,      // Waktu posting
    val postText: String,      // Teks posting
    var likeCount: Int,        // Jumlah suka
    val commentCount: Int,      // Jumlah komentar
    var isLiked: Boolean = false // Properti baru untuk status like
) {
    val id: String = java.util.UUID.randomUUID().toString() // Inisialisasi dengan UUID
}
