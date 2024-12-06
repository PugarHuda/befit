package com.example.tugasbesar
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ScreenKelimaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_kelima)

        // Tombol OK
        val btnOk: Button = findViewById(R.id.btn_ok)
        btnOk.setOnClickListener {
            // Tutup layar ini
            finish()
        }
    }
}