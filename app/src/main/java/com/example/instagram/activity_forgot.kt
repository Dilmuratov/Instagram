package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.instagram.databinding.ActivityErrorBinding
import com.example.instagram.databinding.ActivityForgotBinding

class activity_forgot : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etLogin.addTextChangedListener {
            binding.outlinedTextField.isErrorEnabled = false
            if (binding.etLogin.text.toString().isEmpty()){
                binding.etLogin.error = "Enter your login"
            }
        }

        binding.tvNeedforhelp.setOnClickListener {
            intent = Intent(this, activity_error::class.java)
            startActivity(intent)
        }

        binding.btnSearchaccount.setOnClickListener {
            if (binding.etLogin.text.toString().isEmpty()){
                binding.etLogin.error = "Enter your login"
            } else if (binding.etLogin.text.toString().toCharArray().size < 5){
                binding.etLogin.error = "Error login"
            } else {
                intent = Intent(this, activity_error::class.java)
                startActivity(intent)
            }
        }

    }
}