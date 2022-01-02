package com.berk.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.berk.loginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val sharedPrefUserName = sharedPref.getString("userName", "")
        val sharedPrefPassword = sharedPref.getString("password", "")
        binding.btnLogIn.setOnClickListener {
            if (sharedPrefUserName == binding.edtUsername.text.toString() &&
                sharedPrefPassword == binding.edtPassword.text.toString()
            ) {
                intent = Intent(this@LoginActivity, LoginConfirmActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Username or Password doesn't match. \n Please try again!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        binding.btnSignUp.setOnClickListener {
            intent = Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}