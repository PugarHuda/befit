package com.example.setting


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class friendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_friend)

        // Menghubungkan komponen UI
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val popupContainer = findViewById<FrameLayout>(R.id.popup_container)
        val inviteButton = findViewById<Button>(R.id.invite_button)
        val imageButton4 = findViewById<ImageButton>(R.id.imageButton4) // Tombol ke Community


        // Ketika tombol ImageButton2 ditekan, tampilkan pop-up
        imageButton2.setOnClickListener {
            popupContainer.visibility = View.VISIBLE
        }

        // Ketika tombol Invite di pop-up ditekan, sembunyikan pop-up
        inviteButton.setOnClickListener {
            popupContainer.visibility = View.GONE
        }

        // Ketika tombol ImageButton4 ditekan, buka halaman Community
        imageButton4.setOnClickListener {
            val intent = Intent(this, Community::class.java)
            startActivity(intent)
        }

    }
}
