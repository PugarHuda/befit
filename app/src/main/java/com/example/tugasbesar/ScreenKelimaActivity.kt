package com.example.tugasbesar
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ScreenKelimaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_kelima)

        // Tombol OK
        val intent = Intent(this, ScreenKeenamActivity::class.java)
        startActivity(intent)
        }
    }
