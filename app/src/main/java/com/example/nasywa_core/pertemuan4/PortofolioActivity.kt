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
        enableEdgeToEdge() // Tambahkan ini agar mendukung status bar transparan

        binding = ActivityPortofolioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Tombol Back (ivBack)
        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 2. Padding agar Toolbar di bawah Status Bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.toolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 3. Menangkap data dari Intent (Logika aslimu)
        val judulHalaman = intent.getStringExtra("EXTRA_JUDUL") ?: "Judul Kosong"
        val deskripsiHalaman = intent.getStringExtra("EXTRA_DESC") ?: "Deskripsi tidak tersedia"

        // 4. Menampilkan ke layar
        binding.apply {
            tvJudulPortofolio.text = judulHalaman
            tvDeskripsiPortofolio.text = deskripsiHalaman
        }
    }
}