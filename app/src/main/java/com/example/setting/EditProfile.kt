package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Menangani padding untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val settingLink: ImageView = findViewById(R.id.backk)
        settingLink.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Inisialisasi elemen input
        val etUsername: EditText = findViewById(R.id.etUsername)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPhoneNumber: EditText = findViewById(R.id.etPhoneNumber)
        val btnUpdate: Button = findViewById(R.id.btnUpdate)

        // Klik tombol Update
        btnUpdate.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phoneNumber = etPhoneNumber.text.toString().trim()

            // Validasi input
            when {
                username.isEmpty() -> {
                    showToast("Username is required!")
                }
                email.isEmpty() -> {
                    showToast("Email is required!")
                }
                phoneNumber.isEmpty() -> {
                    showToast("Phone number is required!")
                }
                else -> {
                    showToast("Profile updated successfully!")
                    // Tambahkan logika untuk menyimpan perubahan jika diperlukan
                }
            }
        }
    }

    // Fungsi untuk menampilkan notifikasi
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
