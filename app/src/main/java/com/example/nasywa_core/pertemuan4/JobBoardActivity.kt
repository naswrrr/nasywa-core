package com.example.nasywa_core.pertemuan4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityJobBoardBinding

class JobBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJobBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data dari Intent yang dikirim WelcomeActivity
        val judul = intent.getStringExtra("EXTRA_JUDUL")
        val deskripsi = intent.getStringExtra("EXTRA_DESC")

        // Menampilkan ke layar
        binding.tvJudulJob.text = judul
        binding.tvDeskripsiJob.text = deskripsi
    }
}