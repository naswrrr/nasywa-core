package com.example.nasywa_core.pertemuan3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)

        if (sharedPref.getBoolean("isLogin", false)) {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SOAL B3: Logika Login
        binding.btnLogin.setOnClickListener {
            val user = binding.etUsername.text.toString()
            val pass = binding.etPassword.text.toString()
            val savedUser = sharedPref.getString("SAVED_USER", null)
            val savedPass = sharedPref.getString("SAVED_PASS", null)

            if ((user == pass && user.isNotEmpty()) || (user == savedUser && pass == savedPass)) {
                sharedPref.edit().putBoolean("isLogin", true).apply()
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Username atau Password salah!")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }

        // SOAL B1: Register With Gmail
        binding.btnToRegister.setOnClickListener {
            val inputEmail = EditText(this)
            inputEmail.hint = "contoh@gmail.com"

            // Memberi margin sedikit agar EditText tidak nempel ke pinggir dialog
            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
            inputEmail.layoutParams = lp

            MaterialAlertDialogBuilder(this)
                .setTitle("Register with Gmail")
                .setMessage("Masukkan email Gmail Anda")
                .setView(inputEmail)
                .setPositiveButton("Lanjut") { _, _ ->
                    val email = inputEmail.text.toString()
                    if (email.isEmpty()) {
                        showError("Email tidak boleh kosong!")
                    } else if (!email.endsWith("@gmail.com")) {
                        showError("Email harus menggunakan domain @gmail.com")
                    } else {
                        val intent = Intent(this, RegisterActivity::class.java)
                        intent.putExtra("EXTRA_EMAIL", email)
                        startActivity(intent)
                    }
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    private fun showError(msg: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .show()
    }
}