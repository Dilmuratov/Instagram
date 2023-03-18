package com.example.instagram

import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.ItemProfileBinding

class ProfileViewHolder(private val binding: ItemProfileBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(profile: DC_Profile){
        binding.tvLogin.text = profile.username
    }
}