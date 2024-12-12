package com.example.tugasbesar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        // Cari root view dari layout main_screen
        val rootView: View = findViewById(android.R.id.content)

        // Tambahkan listener untuk klik layar
        rootView.setOnClickListener {
            // Berpindah ke ScreenKeduaActivity
            val intent = Intent(this, ScreenKeduaActivity::class.java)
            startActivity(intent)
        }
    }
}
