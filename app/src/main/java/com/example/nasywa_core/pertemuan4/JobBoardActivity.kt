package com.example.nasywa_core.pertemuan4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.databinding.ActivityJobBoardBinding

class JobBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJobBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityJobBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Tombol Back (ivBack)
        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 2. Padding Toolbar agar tidak tertutup Status Bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.toolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 3. Mengambil data dari Intent (Logika aslimu)
        val judul = intent.getStringExtra("EXTRA_JUDUL") ?: "Info Bina Desa"
        val deskripsi = intent.getStringExtra("EXTRA_DESC") ?: "Portal Informasi Layanan Desa"

        // 4. Menampilkan ke layar (Logika aslimu)
        binding.tvJudulJob.text = judul
        binding.tvDeskripsiJob.text = deskripsi
    }
}