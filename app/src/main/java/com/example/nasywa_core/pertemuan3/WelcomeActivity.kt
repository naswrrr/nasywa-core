package com.example.nasywa_core.pertemuan3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.databinding.ActivityWelcomeBinding
import com.example.nasywa_core.pertemuan2.MainMenuActivity
import com.example.nasywa_core.pertemuan4.JobBoardActivity
import com.example.nasywa_core.pertemuan4.PortofolioActivity
import com.example.nasywa_core.WebViewActivity
import com.example.nasywa_core.pertemuan3.LoginActivity // Pastikan package LoginActivity benar
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. FIXED: Padding sekarang ke 'root' karena Toolbar sudah dihapus
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2. Tombol Kalkulator (MainMenuActivity)
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            // Sesuaikan jika MainMenuActivity butuh EXTRA
            startActivity(intent)
        }

        // 3. Tombol Katalog (JobBoardActivity)
        binding.btnJobBoard.setOnClickListener {
            val intent = Intent(this, JobBoardActivity::class.java)
            // Teks inilah yang akan tampil di halaman sebelah (Intent)
            intent.putExtra("EXTRA_JUDUL", "PlantShop Career")
            intent.putExtra("EXTRA_DESC", "Wujudkan passion menanammu menjadi karir yang luar biasa")
            startActivity(intent)
        }

        // 4. Tombol WebView (Website)
        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // 5. Tombol Portofolio
        binding.btnPortofolio.setOnClickListener {
            val intent = Intent(this, PortofolioActivity::class.java)
            // UBAH TEKS DI SINI AGAR SESUAI PLANTSHOP
            intent.putExtra("EXTRA_JUDUL", "PlantShop Portfolio")
            intent.putExtra("EXTRA_DESC", "Lihat koleksi project tanaman hias kami")
            startActivity(intent)
        }

        // 6. LOGIKA LOGOUT
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Yakin ingin keluar dari akun Bina Desa?")
                .setPositiveButton("Iya") { _, _ ->
                    // Hapus Session Login
                    val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
                    sharedPref.edit().putBoolean("isLogin", false).apply()

                    // Pindah ke Login dan tutup semua halaman lama
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}