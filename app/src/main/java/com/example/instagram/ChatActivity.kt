package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.instagram.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecyclerView.adapter = adapter

        val data = mutableListOf<DC_chat>()
        repeat(30){
            data.add(DC_chat(
                R.drawable.messi_profile,
                "Leonel Messi",
                "Seen 2m ago"
            ))
        }

        adapter.models = data

        binding.ivBack.setOnClickListener {
            intent = Intent(this, Home_activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}