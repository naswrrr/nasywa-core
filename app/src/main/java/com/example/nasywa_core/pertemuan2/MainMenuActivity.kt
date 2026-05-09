package com.example.nasywa_core.pertemuan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar // Tambahkan import ini
import com.example.nasywa_core.R

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // 1. SETUP TOOLBAR OTOMATIS
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Aktifkan judul dan tombol back bawaan
        supportActionBar?.apply {
            title = "Kalkulator Bangun"
            setDisplayHomeAsUpEnabled(true) // Ini otomatis memunculkan tombol back
        }

        // 2. Button navigasi tetap sama
        val btnPersegi = findViewById<Button>(R.id.btnPersegi)
        val btnTabung = findViewById<Button>(R.id.btnTabung)

        btnPersegi.setOnClickListener {
            startActivity(Intent(this, PersegiPanjangActivity::class.java))
        }

        btnTabung.setOnClickListener {
            startActivity(Intent(this, TabungActivity::class.java))
        }
    }

    // 3. FUNGSI WAJIB: Agar tombol back di pojok kiri atas berfungsi
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}