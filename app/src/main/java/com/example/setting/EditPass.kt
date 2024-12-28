package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditPass : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pass)

        // Menangani padding untuk sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi elemen input
        val etCurrentPass: EditText = findViewById(R.id.etCurrentPass)
        val etNewPass: EditText = findViewById(R.id.etNewPass)
        val etConfirmPass: EditText = findViewById(R.id.etConfirmPass)
        val btnUpdate: Button = findViewById(R.id.btnUpdate)

        // Klik tombol Update
        btnUpdate.setOnClickListener {
            val currentPass = etCurrentPass.text.toString().trim()
            val newPass = etNewPass.text.toString().trim()
            val confirmPass = etConfirmPass.text.toString().trim()

            // Validasi input
            when {
                currentPass.isEmpty() -> {
                    showToast("Current password is required!")
                }
                newPass.isEmpty() -> {
                    showToast("New password is required!")
                }
                confirmPass.isEmpty() -> {
                    showToast("Please confirm the new password!")
                }
                newPass != confirmPass -> {
                    showToast("New password and confirmation do not match!")
                }
                else -> {
                    // Menampilkan notifikasi berhasil
                    showToast("Password updated successfully!")
                    // Kembali ke MainActivity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Menutup activity saat ini
                }
            }
        }
    }

    // Fungsi untuk menampilkan notifikasi
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
