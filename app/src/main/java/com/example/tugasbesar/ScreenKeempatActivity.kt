package com.example.tugasbesar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScreenKeempatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_keempat)

        // Referensi elemen UI
        val heightInput: EditText = findViewById(R.id.input_height)
        val weightInput: EditText = findViewById(R.id.input_weight)
        val okButton: Button = findViewById(R.id.btn_ok)

        // Aksi tombol OK
        okButton.setOnClickListener {
            val height = heightInput.text.toString()
            val weight = weightInput.text.toString()

            // Validasi input
            if (height.isEmpty() || weight.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            } else {
                // Proses data tinggi dan berat
                Toast.makeText(this, "Height: $height cm, Weight: $weight kg", Toast.LENGTH_SHORT).show()

                // Pindah ke ScreenKelimaActivity
                val intent = Intent(this, ScreenKelimaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
