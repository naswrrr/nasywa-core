package com.example.nasywa_core.pertemuan3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityLoginBinding
import com.example.nasywa_core.pertemuan4.PortofolioActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString()
            val pass = binding.etPassword.text.toString()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                // Simpan status login
                val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("USER_NAME", user)
                editor.apply()

                // Pindah ke WelcomeActivity (Halaman Utama kamu)
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
            }
        }
    }
}