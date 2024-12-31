package com.example.setting

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private var postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // Fungsi untuk memperbarui data
    fun updateData(newPostList: List<Post>) {
        postList = newPostList
        notifyDataSetChanged() // Memberitahu adapter bahwa data telah berubah
    }

    // ViewHolder class
    inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar: ImageView = view.findViewById(R.id.avatar)
        val username: TextView = view.findViewById(R.id.username)
        val postTime: TextView = view.findViewById(R.id.post_time)
        val postText: TextView = view.findViewById(R.id.post_text)
        val likeButton: ImageView = view.findViewById(R.id.like_button)
        val likeCount: TextView = view.findViewById(R.id.like_count)
        val commentButton: ImageView = view.findViewById(R.id.comment_button)
        val commentCount: TextView = view.findViewById(R.id.comment_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]

        // Bind data ke View
        holder.username.text = post.username
        holder.postTime.text = post.postTime
        holder.postText.text = post.postText
        holder.likeCount.text = post.likeCount.toString()
        holder.commentCount.text = post.commentCount.toString()

        // Set gambar berdasarkan status like
        if (post.isLiked) {
            holder.likeButton.setImageResource(R.drawable.ic_liked)
        } else {
            holder.likeButton.setImageResource(R.drawable.ic_like)
        }

        // Example: Adding click listeners
        holder.likeButton.setOnClickListener {
            post.isLiked = !post.isLiked // Toggle status like
            if (post.isLiked) {
                post.likeCount += 1
            } else {
                post.likeCount -= 1
            }

            notifyItemChanged(position) // Perbarui tampilan
        }
        holder.commentButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("postId", post.id) // Kirim data post ID jika diperlukan
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}