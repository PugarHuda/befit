package com.example.setting
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class PostAdapter (private val postList: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
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
        holder.username.text = post.username
        holder.postTime.text = post.postTime
        holder.postText.text = post.postText
        holder.likeCount.text = post.likeCount.toString()
        holder.commentCount.text = post.commentCount.toString()

        // Example: Adding click listeners
        holder.likeButton.setOnClickListener {
            // Handle like button click
        }
        holder.commentButton.setOnClickListener {
            // Handle comment button click
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}