package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ScreenKetigaActivity : AppCompatActivity() {

    private var selectedGender: String? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_ketiga)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference

        val maleButton: Button = findViewById(R.id.btn_male)
        val femaleButton: Button = findViewById(R.id.btn_female)
        val nextButton: Button = findViewById(R.id.btn_next_step_gender)

        maleButton.setOnClickListener {
            selectedGender = "Male"
            Toast.makeText(this, "Anda memilih Laki-laki", Toast.LENGTH_SHORT).show()
        }

        femaleButton.setOnClickListener {
            selectedGender = "Female"
            Toast.makeText(this, "Anda memilih Perempuan", Toast.LENGTH_SHORT).show()
        }

        nextButton.setOnClickListener {
            if (selectedGender == null) {
                Toast.makeText(this, "Harap pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
            } else {
                val username = intent.getStringExtra("USERNAME")

                // Simpan gender ke Firebase
                saveGenderToFirebase(username, selectedGender)

                // Pindah ke aktivitas berikutnya dan kirimkan data gender
                val intent = Intent(this, ScreenKeempatActivity::class.java)
                intent.putExtra("GENDER", selectedGender)
                startActivity(intent)
            }
        }
    }

    private fun saveGenderToFirebase(username: String?, gender: String?) {
        if (username != null && gender != null) {
            val userId = FirebaseDatabase.getInstance().reference.push().key
            val userGenderData = HashMap<String, Any>()
            userGenderData["username"] = username
            userGenderData["gender"] = gender

            if (userId != null) {
                database.child("users").child(userId).setValue(userGenderData)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Jenis kelamin berhasil disimpan!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Gagal menyimpan jenis kelamin", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}
