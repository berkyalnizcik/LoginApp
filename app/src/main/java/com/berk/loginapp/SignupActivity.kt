package com.berk.loginapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.berk.loginapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnSignUp.setOnClickListener {
                val fullname = edtFullName.text.toString()
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()
                val sharedPref = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
                val sharedPrefEditor = sharedPref.edit()
                sharedPrefEditor.putString("fullName", fullname).apply()
                sharedPrefEditor.putString("userName", username).apply()
                sharedPrefEditor.putString("password", password).apply()
                if (fullname.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(this@SignupActivity, SignupConfirmActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Please fill in all blanks!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}