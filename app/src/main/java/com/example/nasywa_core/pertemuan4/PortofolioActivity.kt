package com.example.nasywa_core.pertemuan4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityPortofolioBinding

class PortofolioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPortofolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityPortofolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Menangkap data yang dikirim dari WelcomeActivity via Intent
        // Nama "EXTRA_JUDUL" dan "EXTRA_DESC" harus sama persis dengan yang ada di WelcomeActivity
        val judulHalaman = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsiHalaman = intent.getStringExtra("EXTRA_DESC")

        // 2. Menampilkan data ke TextView di XML
        // Kita gunakan binding.idTextView untuk set teksnya
        binding.tvJudulPortfolio.text = judulHalaman
        binding.tvDeskripsiPortfolio.text = deskripsiHalaman
    }
}