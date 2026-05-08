package com.example.nasywa_core.pertemuan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.R

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // 1. Setup Toolbar & Back Button (Custom ala Lab)
        val ivBack = findViewById<ImageView>(R.id.ivBack)
        ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke WelcomeActivity
        }

        // 2. Button yang sudah ada di kodemu (TIDAK BERUBAH)
        val btnPersegi = findViewById<Button>(R.id.btnPersegi)
        val btnTabung = findViewById<Button>(R.id.btnTabung)

        btnPersegi.setOnClickListener {
            startActivity(Intent(this, PersegiPanjangActivity::class.java))
        }

        btnTabung.setOnClickListener {
            startActivity(Intent(this, TabungActivity::class.java))
        }
    }
}