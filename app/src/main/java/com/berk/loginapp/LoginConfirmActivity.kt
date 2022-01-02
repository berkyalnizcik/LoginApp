package com.berk.loginapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berk.loginapp.databinding.ActivityLoginConfirmBinding

class LoginConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginConfirmBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val sharedPrefFullName = sharedPref.getString("fullName", "")
        val sharedPrefUserName = sharedPref.getString("userName", "")
        val sharedPrefPassword = sharedPref.getString("password", "")
        binding.apply {
            tvFullName.text = "Full Name : $sharedPrefFullName"
            tvUsername.text = "Username : $sharedPrefUserName"
            tvPassword.text = "Password : $sharedPrefPassword"
        }
        binding.btnBackToMain.setOnClickListener {
            intent = Intent(this@LoginConfirmActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}