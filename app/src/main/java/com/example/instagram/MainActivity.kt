package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.instagram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etLogin.addTextChangedListener {
            binding.outlinedTextField.isErrorEnabled = false

            if (binding.etLogin.text.toString().isEmpty()) {
                binding.etLogin.error = "Please enter your login!"
            }
        }

        binding.etParol.addTextChangedListener {
            binding.outlinedTextField2.isErrorEnabled = false

            if (binding.etParol.text.toString().isEmpty()) {
                binding.etParol.error = "Please enter your password!"
            }
        }

        binding.btnForgotpassword.setOnClickListener {
            intent = Intent(this, activity_forgot::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            intent = Intent(this, activity_createaccount::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {

            if (binding.etLogin.text.toString().isEmpty()) {
                binding.etLogin.error = "Enter your login!"
            } else
                if (binding.etLogin.text.toString().isEmpty()) {
                    binding.etParol.error = "Enter your password!"
                } else
                    if (binding.etLogin.text.toString().toCharArray().size < 5) {
                        binding.tvError.text = "Check the correctness of the entered login"
                    } else
                        if (binding.etParol.text.toString().toCharArray().size < 8) {
                            binding.tvError.text = "Check the correctness of the entered password"
                        } else
                            if (binding.etLogin.text.toString()
                                    .isNotEmpty() && binding.etParol.text.toString()
                                    .isNotEmpty()
                            ) {
                                intent = Intent(this, Home_activity::class.java)
                                startActivity(intent)
                            }
        }
    }
}