package com.example.tugasbesar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasbesar.R  // Pastikan ada import ini

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen) // Pastikan file layout main_screen.xml ada
    }
}
