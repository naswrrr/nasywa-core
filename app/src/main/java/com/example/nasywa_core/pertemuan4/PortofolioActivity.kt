package com.example.nasywa_core.pertemuan4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.databinding.ActivityPortofolioBinding

class PortofolioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPortofolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPortofolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. SETUP TOOLBAR OTOMATIS
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Portfolio Bina Desa" // Set judul halaman
            setDisplayHomeAsUpEnabled(true) // Munculkan tombol back bawaan
        }

        // 3. Menangkap data dari Intent
        val judulHalaman = intent.getStringExtra("EXTRA_JUDUL") ?: "Judul Kosong"
        val deskripsiHalaman = intent.getStringExtra("EXTRA_DESC") ?: "Deskripsi tidak tersedia"

        // 4. Menampilkan ke layar
        binding.apply {
            tvJudulPortofolio.text = judulHalaman
            tvDeskripsiPortofolio.text = deskripsiHalaman
        }
    }

    // 5. WAJIB: Agar tombol back di toolbar berfungsi kembali ke halaman sebelumnya
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}