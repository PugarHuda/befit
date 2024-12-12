package com.example.tugasbesar

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup) // Pastikan file XML Anda adalah activity_signup

        // Spinner untuk memilih negara
        val spCountry = findViewById<Spinner>(R.id.spCountry)

        // Data negara
        val countries = arrayOf("Pilih Negara", "Indonesia", "Malaysia", "Singapura", "Thailand", "Filipina", "Vietnam")

        // Adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCountry.adapter = adapter

        // Tombol Register
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // Field input (pastikan ID sesuai dengan XML Anda)
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etBirthDate = findViewById<EditText>(R.id.etBirthdate)
        val etName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        btnRegister.setOnClickListener {
            // Ambil nilai dari input
            val firstName = etFirstName.text.toString().trim()
            val birthDate = etBirthDate.text.toString().trim()
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val selectedCountry = spCountry.selectedItem.toString()

            // Validasi input
            when {
                firstName.isEmpty() -> {
                    etFirstName.error = "First name harus diisi"
                    etFirstName.requestFocus()
                }
                name.isEmpty() -> {
                    etName.error = "Nama harus diisi"
                    etName.requestFocus()
                }
                email.isEmpty() -> {
                    etEmail.error = "Email harus diisi"
                    etEmail.requestFocus()
                }
                birthDate.isEmpty() -> {
                    etBirthDate.error = "Tanggal lahir harus diisi"
                    etBirthDate.requestFocus()
                }

                selectedCountry == "Pilih Negara" -> {
                    Toast.makeText(this, "Silakan pilih negara.", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    etPassword.error = "Password harus diisi"
                    etPassword.requestFocus()
                }

                else -> {
                    // Jika validasi berhasil
                    Toast.makeText(this, "Pendaftaran berhasil!", Toast.LENGTH_SHORT).show()

                    // Logika pengiriman data ke server atau aktivitas lain
                    // Navigasi ke LoginActivity atau halaman lain
                }
            }
        }

        // Redirect ke Login
        val tvLoginRedirect = findViewById<TextView>(R.id.tvLoginRedirect)
        tvLoginRedirect.setOnClickListener {
            // Navigasi ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
