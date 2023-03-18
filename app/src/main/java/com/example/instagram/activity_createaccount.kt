package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.instagram.databinding.ActivityCreateaccountBinding
import kotlin.math.min

class activity_createaccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCreateaccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            if (binding.etName.text.toString().isEmpty()) {
                binding.etName.error = "Enter your name!"
            } else if (binding.etSurname.text.toString().isEmpty()) {
                binding.etSurname.error = "Enter your surname!"
            } else if (binding.etBorn.text.toString().isEmpty()) {
                binding.etBorn.error = "Enter your birthday!"
            } else if (binding.etUsername.text.toString().isEmpty()) {
                binding.etUsername.error = "Create your username!"
            } else if (binding.etPassword.text.toString().isEmpty()) {
                binding.etPassword.error = "Enter your password!"
            } else if (!password_correct(binding.etPassword.text.toString())) {
                binding.etPassword.error = password_uncorrect(binding.etPassword.text.toString())
            } else if (binding.etPassword.text.toString() != binding.etRepeatpassword.text.toString()) {
                binding.etRepeatpassword.error = "Check if the passwords are the same"
            } else {
                intent = Intent(this, Home_activity::class.java)
                startActivity(intent)
                finish()
            }
        }

        binding.etName.addTextChangedListener {
            binding.outlinedTextField.isErrorEnabled = false

            if (binding.etName.text.toString().isEmpty()) {
                binding.etName.error = "Enter your name!"
            }
        }

        binding.etSurname.addTextChangedListener {
            binding.outlinedTextField2.isErrorEnabled = false

            if (binding.etSurname.text.toString().isEmpty()) {
                binding.etSurname.error = "Enter your surname!"
            }
        }

        binding.etBorn.addTextChangedListener {
            binding.outlinedTextField3.isErrorEnabled = false

            if (binding.etBorn.text.toString().isEmpty()) {
                binding.etBorn.error = "Enter your birthday!"
            }
        }

        binding.etUsername.addTextChangedListener {
            binding.outlinedTextField4.isErrorEnabled = false

            if (binding.etUsername.text.toString().isEmpty()) {
                binding.etUsername.error = "Create your username!"
            }
        }

        binding.etPassword.addTextChangedListener {
            binding.outlinedTextField5.isErrorEnabled = false

            if (binding.etPassword.text.toString().isEmpty()) {
                binding.etPassword.error = "Create your password!"
            }
            else if (!password_correct(binding.etPassword.text.toString())){
                binding.etPassword.error = password_uncorrect(binding.etPassword.text.toString())
            }
        }

        binding.etRepeatpassword.addTextChangedListener {
            binding.outlinedTextField.isErrorEnabled = false

            if (binding.etRepeatpassword.text.toString().isEmpty()) {
                binding.etRepeatpassword.error = "Repeat your password!"
            }
            else if (!passwords_some(binding.etPassword.text.toString(), binding.etRepeatpassword.text.toString())){
                binding.etRepeatpassword.error = "Check if the passwords are the same"
            }
        }

        binding.tvTerms2.setOnClickListener {
            intent = Intent(this, activity_error::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun password_lenght(password: String): Boolean {
        return password.length >= 8
    }

    //Bas harip bar ekenligi
    fun password_uppercase(password: String): Boolean {
        var bool = true
        password.toCharArray().forEach { it ->
            bool = it.code in 65..90
            if (bool) {
                return true
            }
        }
        return false
    }

    //kishi harip bar ekenligi
    fun password_lowercase(password: String): Boolean {
        var bool = true
        password.toCharArray().forEach { it ->
            bool = it.code in 97..122
            if (bool) {
                return true
            }
        }
        return false
    }

    //symbol bar ekenligi
    fun password_symbol(password: String): Boolean {
        var bool = true
        password.toCharArray().forEach { it ->
            bool = (it.code in 33..47) || (it.code in 58..64) ||
                    (it.code in 91..96) || (it.code in 123..126)
            if (bool) {
                return true
            }
        }
        return false
    }

    //cifr bar ekenligi
    fun password_digit(password: String): Boolean {
        var bool = true
        password.toCharArray().forEach { it ->
            bool = it.code in 48..57
            if (bool) {
                return true
            }
        }
        return false
    }

    //Passwordtin durisligin tekseredi
    fun password_correct(password: String): Boolean {
        return password_lenght(password) && password_uppercase(password) &&
                password_lowercase(password) && password_symbol(password) &&
                password_digit(password)
    }

    //Passwordtin qateligin tawadi
    fun password_uncorrect(password: String): String {
        if (!password_lenght(password)) return "Password lenght is short"
        else if (!password_uppercase(password)) return "Password hasn't got a uppercase letter"
        else if (!password_lowercase(password)) return "Password hasn't got a lowercase letter"
        else if (!password_symbol(password)) return "Password hasn't got a symbol"
        else if (!password_digit(password)) return "Password hasn't got a digit"
        else return "Correct"
    }

    //Passwordlar birdeyligi
    fun passwords_some(password: String, passwordrepeat: String): Boolean{
        if (password == passwordrepeat) return true
        return false
    }
}
