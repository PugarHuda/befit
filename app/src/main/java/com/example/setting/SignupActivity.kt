package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

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

        // Field input
        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etBirthDate = findViewById<EditText>(R.id.etBirthdate)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        // Tombol register di klik
        btnRegister.setOnClickListener {
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val birthDate = etBirthDate.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val selectedCountry = spCountry.selectedItem.toString()

            // Validasi input
            when {
                firstName.isEmpty() -> {
                    etFirstName.error = "Nama depan harus diisi"
                    etFirstName.requestFocus()
                }
                lastName.isEmpty() -> {
                    etLastName.error = "Nama belakang harus diisi"
                    etLastName.requestFocus()
                }
                birthDate.isEmpty() -> {
                    etBirthDate.error = "Tanggal lahir harus diisi"
                    etBirthDate.requestFocus()
                }
                email.isEmpty() -> {
                    etEmail.error = "Email harus diisi"
                    etEmail.requestFocus()
                }
                selectedCountry == "Pilih Negara" -> {
                    Toast.makeText(this, "Silakan pilih negara.", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    etPassword.error = "Password harus diisi"
                    etPassword.requestFocus()
                }
                else -> {
                    // Simpan ke Firebase
                    val database = FirebaseDatabase.getInstance()
                    val usersRef = database.getReference("users")
                    val userId = usersRef.push().key ?: ""

                    val user = mapOf(
                        "firstName" to firstName,
                        "lastName" to lastName,
                        "birthDate" to birthDate,
                        "email" to email,
                        "password" to password, // Jangan simpan plaintext untuk produksi!
                        "country" to selectedCountry
                    )

                    usersRef.child(userId).setValue(user).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Pendaftaran berhasil!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Gagal menyimpan data: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        // Redirect ke LoginActivity
        val tvLoginRedirect = findViewById<TextView>(R.id.tvLoginRedirect)
        tvLoginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
