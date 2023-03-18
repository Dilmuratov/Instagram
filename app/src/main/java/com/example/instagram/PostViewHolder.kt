package com.example.instagram

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.ItemPostBinding

class PostViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(post: DC_Post){
        binding.login.text = post.username
        binding.location.text = post.location
        binding.tvPart2.text = post.yourFollower
        binding.tvPart4.text = post.likesNumber.toString()
        binding.tvComment1.text = post.username
        binding.tvComment2.text = post.commentary
        binding.tvCommentLogin.text = post.username
        binding.tvCommentoflogin.text = post.comment

    }
}