package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScreenKeenamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_keenam) // Mengaitkan layout screen_keenam.xml

        // Inisialisasi tombol OK
        val okButton = findViewById<Button>(R.id.btn_ok)

        // Tambahkan aksi saat tombol OK ditekan
        okButton.setOnClickListener {
            Toast.makeText(this, "OK clicked! Navigating to DailyTask2...", Toast.LENGTH_SHORT).show()

            // Intent untuk navigasi ke DailyTask2Activity
            val intent = Intent(this, DailyTaskActivity::class.java)
            startActivity(intent)
        }
    }
}
