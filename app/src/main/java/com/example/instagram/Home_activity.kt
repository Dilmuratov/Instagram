package com.example.instagram

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.instagram.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
class Home_activity : AppCompatActivity() {
    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVActivityHome.adapter = adapter

        val data = mutableListOf<Any>()

        val profile = mutableListOf<DC_Profile>()
        repeat(25){i ->
            profile.add(
                DC_Profile(
                    i,
                    "leomessi"
            ))
        }
        repeat(40){i ->
            if (i == 0){
                data.add(DC_ProfileList(i, profile))
            }
            else {
                data.add(DC_Post(i,
                "leomessi",
                "Rosario",
                "Cristiano ",
                1234580,
                " Ches with my best opponent ...more",
                " Great game"))
            }
        }

        adapter.models = data

        binding.ivChat.setOnClickListener {
            intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

    }
}