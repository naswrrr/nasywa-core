package com.example.nasywa_core.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.R

class PersegiPanjangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_persegi_panjang)

        // 1. Setup Toolbar & Tombol Back Manual
        val ivBack = findViewById<ImageView>(R.id.ivBack)
        ivBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Kembali ke MainMenuActivity
        }

        // 2. Padding agar Toolbar tidak tertutup Status Bar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(toolbar) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 3. Inisialisasi Komponen Kalkulator
        val inputPanjang = findViewById<EditText>(R.id.inputPanjang)
        val inputLebar = findViewById<EditText>(R.id.inputLebar)
        val hasil = findViewById<TextView>(R.id.txtHasil)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        // 4. Logika Perhitungan
        btnHitung.setOnClickListener {
            val p = inputPanjang.text.toString().toDoubleOrNull()
            val l = inputLebar.text.toString().toDoubleOrNull()

            if (p == null || l == null) {
                hasil.text = "Input tidak valid!"
                return@setOnClickListener
            }

            val luas = p * l
            hasil.text = "Luas = $luas"
        }
    }
}