package com.example.tugasbesar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScreenKeduaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_kedua)

        // Referensi ke elemen UI
        val usernameInput: EditText = findViewById(R.id.input_username)
        val nextButton: Button = findViewById(R.id.btn_next_step)

        // Aksi tombol "NEXT STEP"
        nextButton.setOnClickListener {
            val username = usernameInput.text.toString()

            // Validasi input
            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter a username!", Toast.LENGTH_SHORT).show()
            } else {
                // Lanjutkan ke layar berikutnya (jika ada)
                Toast.makeText(this, "Hello, $username!", Toast.LENGTH_SHORT).show()
                // Contoh pindah ke aktivitas lain
                val intent = Intent(this, ScreenKetigaActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }
    }
}