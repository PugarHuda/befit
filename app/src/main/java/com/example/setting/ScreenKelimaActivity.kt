package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ScreenKelimaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_kelima)

        // Referensi tombol OK
        val btnOk = findViewById<Button>(R.id.btn_ok)

        // Set OnClickListener untuk tombol OK
        btnOk.setOnClickListener {
            // Intent ke halaman DailyTask2
            val intent = Intent(this, DailyTaskActivity::class.java)
            startActivity(intent)
        }
    }
}
