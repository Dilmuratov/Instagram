package com.example.instagram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.instagram.databinding.ItemChatBinding
import com.example.instagram.databinding.ItemPostBinding
import com.example.instagram.databinding.ProfileListBinding

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    var models = listOf<Any>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (models[position] is DC_ProfileList) 1
        else if (models[position] is DC_Post) 2
        else 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.profile_list, parent, false)
                val binding = ProfileListBinding.bind(view)
                return ProfileListViewHolder(binding)
            }

            2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_post, parent, false)
                val binding = ItemPostBinding.bind(view)
                return PostViewHolder(binding)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_chat, parent, false)
                val binding = ItemChatBinding.bind(view)
                return ChatViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            1 -> {
                (holder as ProfileListViewHolder).bind(models[position] as DC_ProfileList)
            }

            2 -> {
                (holder as PostViewHolder).bind(models[position] as DC_Post)
            }

            3 -> {
                (holder as ChatViewHolder).bind(models[position] as DC_chat)
            }
        }
    }
}