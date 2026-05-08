package com.example.nasywa_core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.nasywa_core.pertemuan3.LoginActivity // Tujuan ke P3
import com.example.nasywa_core.pertemuan3.WelcomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            delay(3000)

            val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // Jika sudah login, langsung ke WelcomeActivity (Main kamu)
                val intent = Intent(this@SplashScreenActivity, WelcomeActivity::class.java)
                startActivity(intent)
            } else {
                // Jika belum login, arahkan ke LoginActivity (P3)
                val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }
    }
}