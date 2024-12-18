package com.example.setting

import PostComment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.setting.R

class CommentAdapter(private val commentList: List<PostComment>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = commentList[position]

        // Bind data komentar utama
        holder.usernameTextView.text = comment.username
        holder.timeTextView.text = comment.time
        holder.commentTextView.text = comment.comment

        // Menampilkan balasan jika ada
        if (comment.replies.isNotEmpty()) {
            holder.repliesLayout.visibility = View.VISIBLE

            // Set adapter untuk balasan
            val replyAdapter = CommentAdapter(comment.replies)
            holder.repliesRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
            holder.repliesRecyclerView.adapter = replyAdapter
        } else {
            holder.repliesLayout.visibility = View.GONE
        }

        // Menambahkan listener untuk memilih komentar yang ingin dibalas
        holder.itemView.setOnClickListener {
            // Menggunakan context untuk memanggil activity yang ada
            (it.context as? CommentActivity)?.onCommentSelected(comment)
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val commentTextView: TextView = itemView.findViewById(R.id.commentTextView)
        val repliesLayout: LinearLayout = itemView.findViewById(R.id.repliesLayout)
        val repliesRecyclerView: RecyclerView = itemView.findViewById(R.id.repliesRecyclerView)
    }
}

