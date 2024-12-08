package com.example.dailytask2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddChallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_challenge)

        val challengeLink : ImageView = findViewById(R.id.backButton)

        challengeLink.setOnClickListener {
        val intent= Intent (this, ChallengeActivity::class.java)
        startActivity(intent)
        }

        // Langkah 2: Atur adapter untuk spinner
        val spinner: Spinner = findViewById(R.id.challengeCategory)
        val categories = resources.getStringArray(R.array.challenge_categories)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCategory = parent?.getItemAtPosition(position).toString()
                if (position == 0) {
                    // Tampilkan pesan jika placeholder dipilih
                    Toast.makeText(this@AddChallengeActivity, "Please select a category", Toast.LENGTH_SHORT).show()
                } else {
                    // Lakukan sesuatu dengan kategori yang dipilih
                    Toast.makeText(this@AddChallengeActivity, "Selected: $selectedCategory", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Tidak ada yang dipilih
            }
            }
        }
}