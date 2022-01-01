package com.berk.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berk.loginapp.databinding.ActivitySignupConfirmBinding

class SignupConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupConfirmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackToMain.setOnClickListener {
            intent= Intent(this@SignupConfirmActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}