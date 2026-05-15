package com.example.nasywa_core.pertemuan3

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SOAL B1: Terima email dan set ke field email
        val emailTerbawa = intent.getStringExtra("EXTRA_EMAIL")
        binding.etEmail.setText(emailTerbawa)
        binding.etEmail.isEnabled = false // Email tidak boleh diubah (B2)

        binding.btnRegister.setOnClickListener {
            if (isInputValid()) {
                simpanKeSharedPref()
            }
        }
    }

    private fun isInputValid(): Boolean {
        var valid = true
        val nama = binding.etNama.text.toString()
        val user = binding.etUsernameReg.text.toString()
        val pass = binding.etPasswordReg.text.toString()

        // SOAL B2: Validasi
        binding.tilNama.error = null
        binding.tilUsernameReg.error = null
        binding.tilPasswordReg.error = null

        if (nama.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
            valid = false
        }

        if (pass.length < 6) {
            binding.tilPasswordReg.error = "Password minimal 6 karakter"
            valid = false
        }

        if (user.contains(" ")) {
            binding.tilUsernameReg.error = "Username tidak boleh mengandung spasi"
            valid = false
        }

        return valid
    }

    private fun simpanKeSharedPref() {
        val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
        sharedPref.edit().apply {
            putString("SAVED_NAME", binding.etNama.text.toString())
            putString("SAVED_USER", binding.etUsernameReg.text.toString())
            putString("SAVED_PASS", binding.etPasswordReg.text.toString())
            apply()
        }
        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_LONG).show()
        finish()
    }
}