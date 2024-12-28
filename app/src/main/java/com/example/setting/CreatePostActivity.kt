package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_post)

        val challengeText = findViewById<TextView>(R.id.challengeText)
        val btnPost = findViewById<Button>(R.id.btnPost)
        val createText = findViewById<EditText>(R.id.createText)

        // Mengatur aksi pada tombol cancel
        challengeText.setOnClickListener {
            finish() // Menutup activity ini (kembali ke activity sebelumnya)
        }

        // Mengatur aksi pada tombol post
        btnPost.setOnClickListener {
            val postText = createText.text.toString()

            if (postText.isNotEmpty()) {
                // Menyimpan pesan ke SharedPreferences
                val sharedPreferences = getSharedPreferences("posts", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("newPost", postText)
                editor.apply()

                // Beri feedback ke pengguna
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show()

                // Pindah ke halaman Community
                val intent = Intent(this, Community::class.java)
                intent.putExtra("newPost", postText)
                startActivity(intent)
                finish()
            } else {
                // Tindakan jika input text kosong
                Toast.makeText(this, "Please fill in the message", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
