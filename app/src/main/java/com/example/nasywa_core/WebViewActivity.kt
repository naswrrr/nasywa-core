package com.example.nasywa_core

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Aktifkan Edge-to-Edge
        enableEdgeToEdge()

        // 2. Inisialisasi View Binding
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 3. Atur Padding Toolbar agar tidak tertutup Status Bar
        ViewCompat.setOnApplyWindowInsetsListener(binding.toolbarWeb) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 4. Konfigurasi Tombol Back di Toolbar
        binding.ivBack.setOnClickListener {
            // Cek jika web bisa back, maka back di web. Jika tidak, tutup activity.
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            } else {
                finish()
            }
        }

        // 5. Konfigurasi WebView
        binding.webView.apply {
            webViewClient = WebViewClient() // Link dibuka di aplikasi
            settings.javaScriptEnabled = true // Aktifkan JS
            loadUrl("https://naswazaro.alwaysdata.net/") // URL tujuan
        }

        // 6. SOLUSI BIAR GAK MERAH: Gunakan OnBackPressedDispatcher
        // Ini pengganti fungsi onBackPressed() yang lama
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack() // Kembali ke halaman web sebelumnya
                } else {
                    // Jika web sudah di halaman paling depan, keluar dari Activity
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }
}