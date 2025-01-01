package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ScreenKeduaActivity : AppCompatActivity() {

    // Deklarasi referensi Firebase Realtime Database
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_kedua)

        // Inisialisasi Firebase Database
        database = FirebaseDatabase.getInstance().reference

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
                // Menyimpan username ke Firebase Realtime Database
                saveUsernameToFirebase(username)

                // Lanjutkan ke layar berikutnya
                Toast.makeText(this, "Hello, $username!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ScreenKetigaActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }
    }

    private fun saveUsernameToFirebase(username: String) {
        // Menyimpan data di Firebase Realtime Database dengan key "users"
        val userId = database.push().key // Membuat ID unik untuk setiap pengguna
        val user = HashMap<String, Any>()
        user["username"] = username

        // Menyimpan data ke dalam node "users" dengan key unik
        if (userId != null) {
            database.child("users").child(userId).setValue(user)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
