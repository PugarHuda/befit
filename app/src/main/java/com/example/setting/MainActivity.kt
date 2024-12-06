package com.example.setting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
//        KE PAGE EDIT PROFILE
        findViewById<Button>(R.id.EditProf).setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }

//        KE PAGE EDIT PASS
        findViewById<Button>(R.id.ChangePass).setOnClickListener {
            val intent = Intent(this, EditPass::class.java)
            startActivity(intent)
        }


    }
}