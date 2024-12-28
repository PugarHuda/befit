package com.example.setting

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager

class MainActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1 // Request code untuk pemilihan gambar
    private lateinit var profileImageView: ImageView

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menghubungkan profileImageView dengan ImageView yang ada di layout
        profileImageView = findViewById(R.id.profileImageView) // Ganti dengan ID ImageView Anda

        // Cek permission untuk akses penyimpanan
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                100
            )
        }

        // KE PAGE EDIT PROFILE
        findViewById<Button>(R.id.EditProf).setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }

        // KE PAGE EDIT PASS
        findViewById<Button>(R.id.ChangePass).setOnClickListener {
            val intent = Intent(this, EditPass::class.java)
            startActivity(intent)
        }

        // Inventory
        val characterList = listOf(
            Character("Character 1", R.drawable.char1),
            Character("Character 2", R.drawable.char2),
            Character("Character 3", R.drawable.char3)
        )
        findViewById<Button>(R.id.Inventory).setOnClickListener {
            val dialogFragment = CharacterDialogFragment(characterList)
            dialogFragment.show(supportFragmentManager, "CharacterDialog")
        }

        // Logout
        findViewById<Button>(R.id.Logout).setOnClickListener {
            showLogoutDialog()
        }

        // Delete Account
        findViewById<Button>(R.id.DelAcc).setOnClickListener {
            showDeleteAccountDialog()
        }

        // Klik icon kamera untuk membuka galeri
        findViewById<ImageView>(R.id.camera_icon).setOnClickListener {
            openGallery()
        }
    }

    // Membuka galeri untuk memilih gambar
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Menangani hasil dari pemilihan gambar
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            // Menampilkan gambar yang dipilih ke ImageView
            profileImageView.setImageURI(imageUri)
        }
    }

    // Menangani izin runtime
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showLogoutDialog() {
        // Membuat dialog
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.logout_box)

        // Menghubungkan tombol pada dialog
        val logoutButton = dialog.findViewById<Button>(R.id.btn_logout)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        // Klik Logout
        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logout successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()

            // Pindah ke halaman login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Menutup halaman ini agar tidak bisa kembali
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
            // Simulasi penghapusan akun
            Toast.makeText(this, "Account deleted successfully", Toast.LENGTH_SHORT).show()
            dialog.dismiss()

            // Pindah ke halaman login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Menutup halaman ini
        }

        // Klik Cancel
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        // Menampilkan dialog
        dialog.show()
    }
}
