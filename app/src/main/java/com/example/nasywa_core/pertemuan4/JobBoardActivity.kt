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

        // 1. SETUP TOOLBAR
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Info Karir"
            setDisplayHomeAsUpEnabled(true)
        }

        // 3. Menerima Intent (Sesuai tugas dari Dosen)
        val judul = intent.getStringExtra("EXTRA_JUDUL") ?: "Default Judul"
        val deskripsi = intent.getStringExtra("EXTRA_DESC") ?: "Default Deskripsi"

        // 4. Update UI dengan data dari Intent
        binding.tvJudulJob.text = judul
        binding.tvDeskripsiJob.text = deskripsi
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}