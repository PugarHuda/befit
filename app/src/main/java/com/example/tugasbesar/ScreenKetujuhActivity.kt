package com.example.tugasbesar
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ScreenKetujuhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_ketujuh) // Menggunakan layout screen_ketujuh.xml

        // Inisialisasi tombol OK
        val okButton = findViewById<Button>(R.id.btn_ok_normal)

        // Tambahkan aksi saat tombol OK ditekan
        okButton.setOnClickListener {
            Toast.makeText(this, "OK clicked! Keep it up!", Toast.LENGTH_SHORT).show()
            // Tambahkan logika tambahan jika diperlukan
        }
    }
}
