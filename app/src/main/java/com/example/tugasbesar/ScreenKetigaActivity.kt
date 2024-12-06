package com.example.tugasbesar


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScreenKetigaActivity : AppCompatActivity() {

    // Variabel untuk menyimpan pilihan gender
    private var selectedGender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_ketiga)

        // Referensi elemen UI
        val maleButton: Button = findViewById(R.id.btn_male)
        val femaleButton: Button = findViewById(R.id.btn_female)
        val nextButton: Button = findViewById(R.id.btn_next_step_gender)

        // Aksi tombol "Male"
        maleButton.setOnClickListener {
            selectedGender = "Male"
            Toast.makeText(this, "You selected Male", Toast.LENGTH_SHORT).show()
        }

        // Aksi tombol "Female"
        femaleButton.setOnClickListener {
            selectedGender = "Female"
            Toast.makeText(this, "You selected Female", Toast.LENGTH_SHORT).show()
        }

// Aksi tombol "Next Step"
        nextButton.setOnClickListener {
            if (selectedGender == null) {
                Toast.makeText(this, "Please select a gender!", Toast.LENGTH_SHORT).show()
            } else {
                // Pindah ke aktivitas berikutnya dan kirimkan data gender
                val intent = Intent(this, ScreenKeempatActivity::class.java)
                intent.putExtra("GENDER", selectedGender)
                startActivity(intent)
            }
        }
    }
}
