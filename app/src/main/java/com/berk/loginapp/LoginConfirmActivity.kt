package com.berk.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berk.loginapp.databinding.ActivityLoginConfirmBinding

class LoginConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginConfirmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBackToMain.setOnClickListener {
            intent= Intent(this@LoginConfirmActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}