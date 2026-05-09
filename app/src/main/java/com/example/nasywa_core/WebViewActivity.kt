package com.example.nasywa_core

import android.os.Bundle
import android.webkit.WebSettings
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
        enableEdgeToEdge()

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. SETUP TOOLBAR (Hanya ini yang dibutuhkan)
        setSupportActionBar(binding.toolbarWeb)
        supportActionBar?.apply {
            title = "Sistem Fasilitas Desa"
            setDisplayHomeAsUpEnabled(true)
        }

        // 2. Konfigurasi WebView sisanya tetap sama...
        binding.webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://naswazaro.alwaysdata.net/")
        }

        // 4. Logika Tombol Back HP (Gesture/Fisik)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    // 5. WAJIB: Logika agar panah Back di Toolbar berfungsi untuk WebView
    override fun onSupportNavigateUp(): Boolean {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            finish() // Tutup activity jika history web habis
        }
        return true
    }
}