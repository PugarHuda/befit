package com.example.setting

data class Post(
    val avatarResId: Int,      // Resource ID untuk avatar
    val username: String,      // Nama pengguna
    val postTime: String,      // Waktu posting
    val postText: String,      // Teks posting
    val likeCount: Int,        // Jumlah suka
    val commentCount: Int      // Jumlah komentar
)
