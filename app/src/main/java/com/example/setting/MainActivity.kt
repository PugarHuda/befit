package com.example.setting

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        // Inisialisasi RecyclerView (dari DailyTaskActivity)
        recyclerView = findViewById(R.id.recyclerView)

        // Daftar data NavbarItem
        val navbarItems = listOf(
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_target, "Home"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_home, "Stats"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_shop, "Tasks"),
            RecyclerViewAdapter.NavbarItem(R.drawable.ic_friends, "Settings")
        )

        // Menambahkan LayoutManager untuk menata item secara vertikal
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menambahkan Adapter dan menghubungkannya dengan data
        recyclerViewAdapter = RecyclerViewAdapter(navbarItems)
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun showLogoutDialog() {
        // Membuat dialog
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.logout_box)

        // Menghubungkan tombol pada dialog
        val deleteButton = dialog.findViewById<Button>(R.id.btn_logout)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        // Klik Logout
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
