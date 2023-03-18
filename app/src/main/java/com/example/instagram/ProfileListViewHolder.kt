package com.example.instagram

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.instagram.databinding.ProfileListBinding

class ProfileListViewHolder(private val binding: ProfileListBinding): ViewHolder(binding.root) {
    fun bind(profileList: DC_ProfileList){
        val profileAdapter = ProfileAdapter()
        binding.RVProfileList.adapter = profileAdapter

        profileAdapter.models = profileList.profiles
    }
}