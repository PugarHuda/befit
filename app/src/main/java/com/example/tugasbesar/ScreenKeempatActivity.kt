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
            val heightText = heightInput.text.toString()
            val weightText = weightInput.text.toString()

            // Validasi input kosong
            if (heightText.isEmpty() || weightText.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                // Konversi input menjadi angka
                val height = heightText.toDouble() / 100 // Convert to meters
                val weight = weightText.toDouble()

                // Validasi nilai yang masuk akal
                if (height <= 0 || weight <= 0) {
                    Toast.makeText(this, "Height and weight must be greater than zero!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Hitung BMI
                val bmi = weight / (height * height)

                // Debugging log
                println("Height (meters): $height")
                println("Weight (kg): $weight")
                println("Calculated BMI: $bmi")

                // Tentukan kategori BMI
                val intent = when {
                    bmi < 18.5 -> {
                        Toast.makeText(this, "Underweight: BMI = %.2f".format(bmi), Toast.LENGTH_SHORT).show()
                        Intent(this, ScreenKelimaActivity::class.java)

                    }
                    bmi > 24.9 -> {
                        Toast.makeText(this, "Overweight: BMI = %.2f".format(bmi), Toast.LENGTH_SHORT).show()
                        Intent(this, ScreenKeenamActivity::class.java)
                    }
                    else -> {
                        Toast.makeText(this, "Normal: BMI = %.2f".format(bmi), Toast.LENGTH_SHORT).show()
                        Intent(this, ScreenKetujuhActivity::class.java)

                    }
                }

                // Pindah ke aktivitas yang sesuai
                startActivity(intent)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input format! Use numeric values.", Toast.LENGTH_SHORT).show()
                finish()
            }


        }
    }
}
