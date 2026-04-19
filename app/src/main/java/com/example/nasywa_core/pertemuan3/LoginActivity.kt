package com.example.nasywa_core.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // Mengambil input dari EditText (Pastikan ID-nya benar: etUsername dan etPassword)
            val user = binding.etUsername.text.toString()
            val pass = binding.etPassword.text.toString()

            if (user.isNotEmpty() && pass.isNotEmpty()) {
                // Berpindah ke WelcomeActivity
                val intent = Intent(this, WelcomeActivity::class.java)

                // Opsional: Kamu bisa kirim nama user juga jika ingin ditampilkan di halaman Welcome
                intent.putExtra("USER_NAME", user)

                startActivity(intent)

                // Sesuai aturan logout, setelah pindah ke utama, login biasanya di-finish
                finish()
            } else {
                Toast.makeText(this, "Harap isi username dan password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}