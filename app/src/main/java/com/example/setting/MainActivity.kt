package com.example.setting

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
      /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
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

        // Inventory
        findViewById<Button>(R.id.Inventory).setOnClickListener {
            val intent = Intent(this, EditPass::class.java)
            startActivity(intent)
        }

        // Logout
        findViewById<Button>(R.id.Logout).setOnClickListener {
            showLogoutDialog()
        }
        // Delete Account
        findViewById<Button>(R.id.DelAcc).setOnClickListener {
            showDeleteAccountDialog()
        }


    }
    private fun showLogoutDialog() {
        // Membuat dialog
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.logout_box)

        // Menghubungkan tombol pada dialog
        val deleteButton = dialog.findViewById<Button>(R.id.btn_logout)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        // Klik Delete Account
        deleteButton.setOnClickListener {
            Toast.makeText(this, "Logout successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        // Klik Cancel
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        // Menampilkan dialog
        dialog.show()
    }

    private fun showDeleteAccountDialog() {
        // Membuat dialog
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.delacc_box)

        // Menghubungkan tombol pada dialog
        val deleteButton = dialog.findViewById<Button>(R.id.btn_delete_account)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        // Klik Delete Account
        deleteButton.setOnClickListener {
            Toast.makeText(this, "Account deleted successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        // Klik Cancel
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        // Menampilkan dialog
        dialog.show()
    }
}
