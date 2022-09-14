package com.example.mad_practical3_20012021014_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.core.view.WindowCompat
import com.example.mad_practical3_20012021014_1.databinding.ActivityLoginBinding
import com.example.mad_practical3_20012021014_1.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.signUpText.setOnClickListener{
            Intent(this, RegistrationActivity::class.java).also { startActivity(it) }
            binding.signUpText.movementMethod= LinkMovementMethod.getInstance();
        }

        binding.bottomNavigationView.selectedItemId = R.id.bottom_nav_login
        binding.bottomNavigationView.setOnItemSelectedListener{ it ->
            when(it.itemId){
                R.id.bottom_nav_reg -> {
                    Intent(this, RegistrationActivity::class.java).also {startActivity(it)}
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}