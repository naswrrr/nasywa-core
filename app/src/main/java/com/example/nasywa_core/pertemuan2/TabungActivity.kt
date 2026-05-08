package com.example.nasywa_core.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.R

class TabungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabung)

        // 1. Setup Tombol Back (ivBack)
        val ivBack = findViewById<ImageView>(R.id.ivBack)
        ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 2. Mengatur padding khusus Toolbar agar tidak tertutup status bar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(toolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 3. Inisialisasi Komponen (Asli Kamu)
        val inputJari = findViewById<EditText>(R.id.inputJari)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val hasil = findViewById<TextView>(R.id.txtHasil)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        // 4. Logika Hitung (Asli Kamu)
        btnHitung.setOnClickListener {
            val r = inputJari.text.toString().toDoubleOrNull()
            val t = inputTinggi.text.toString().toDoubleOrNull()

            if (r == null || t == null) {
                hasil.text = "Input tidak valid!"
                return@setOnClickListener
            }

            // Rumus Volume Tabung: PI * r^2 * t
            val volume = 3.14 * r * r * t
            hasil.text = "Volume = %.2f".format(volume)
        }
    }
}