package com.example.setting

data class Goal(
    val icon: Int,      // Resource ID untuk ikon
    val title: String,  // Judul goal
    val progress: String, // Deskripsi progress
    val current: Int,   // Nilai progress saat ini
    val max: Int        // Nilai maksimum progress
)
