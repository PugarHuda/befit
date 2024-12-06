package com.example.tugasbesar

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Menangani klik pada link Sign Up
        val signUpLink: TextView = findViewById(R.id.sign_up_link)
        signUpLink.setOnClickListener {


        }
    }

}
