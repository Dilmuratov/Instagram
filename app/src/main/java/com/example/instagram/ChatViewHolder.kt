package com.example.instagram

import androidx.recyclerview.widget.RecyclerView
import com.example.instagram.databinding.ItemChatBinding

class ChatViewHolder(private val binding: ItemChatBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(chat: DC_chat){
        binding.civProfile.setImageResource(chat.profile)
        binding.tvProfilename.text = chat.profilename
        binding.tvSeenago.text = chat.seeanago
    }
}