package com.example.setting

import PostComment
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.setting.R


class CommentActivity : AppCompatActivity() {

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentList: MutableList<PostComment> // Daftar komentar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        // Inisialisasi RecyclerView dan Adapter
        commentList = mutableListOf()
        commentAdapter = CommentAdapter(commentList)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewComments)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = commentAdapter

        // Ambil referensi dari UI
        val commentInput: EditText = findViewById(R.id.editTextReply)
        val sendCommentButton: ImageButton = findViewById(R.id.buttonSend)

        // Tombol kirim komentar
        sendCommentButton.setOnClickListener {
            val commentText = commentInput.text.toString().trim()
            if (commentText.isNotEmpty()) {
                val newComment = PostComment(

                    username = "Your Username", // Ganti dengan nama pengguna
                    time = "Just now",
                    comment = commentText,
                    replies = listOf() // Belum ada balasan
                )
                addComment(newComment)
                commentInput.text.clear() // Bersihkan input
            }
        }

        // Fungsi untuk tombol kembali
        val backButton = findViewById<ImageButton>(R.id.backButton)
        backButton.setOnClickListener {
            val intent = Intent(this, Community::class.java)
            startActivity(intent) // Membuka halaman Community
            finish() // Menutup aktivitas saat ini
        }
    }

    // Menambahkan komentar baru
    fun addComment(comment: PostComment) {
        commentList.add(comment)
        commentAdapter.notifyItemInserted(commentList.size - 1)
    }

    // Fungsi ini akan dipanggil jika komentar dipilih untuk dibalas
    fun onCommentSelected(comment: PostComment) {
        // Logic untuk balasan
    }

    // Menambahkan balasan ke komentar
    fun addReplyToComment(mainComment: PostComment, reply: PostComment) {
        val index = commentList.indexOf(mainComment)
        if (index != -1) {
            // Menambahkan balasan ke komentar utama
            val updatedComment = mainComment.copy(replies = mainComment.replies + reply)
            commentList[index] = updatedComment
            commentAdapter.notifyItemChanged(index) // Update RecyclerView
        }
    }
}

