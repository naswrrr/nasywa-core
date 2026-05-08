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
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Padding Toolbar (Biar tidak nabrak status bar)
        ViewCompat.setOnApplyWindowInsetsListener(binding.toolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Tombol Back Manual
        binding.ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 1. Tombol Kalkulator
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "BINA DESA CALC")
            intent.putExtra("EXTRA_DESC", "Kalkulator pendukung sarana desa.")
            startActivity(intent)
        }

        // 2. Tombol Job Board / Katalog
        binding.btnJobBoard.setOnClickListener {
            val intent = Intent(this, JobBoardActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "BINA DESA INFO")
            startActivity(intent)
        }

        // 3. Tombol WebView (BARU TAMBAHAN)
        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // 4. Tombol Portofolio
        binding.btnPortofolio.setOnClickListener {
            val intent = Intent(this, PortofolioActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "BINA DESA PORTFOLIO")
            startActivity(intent)
        }

        // LOGIKA LOGOUT
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Yakin ingin keluar dari akun Bina Desa?")
                .setPositiveButton("Iya") { _, _ ->
                    val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", false)
                    editor.apply()

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