package com.example.nasywa_core.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.R

class PersegiPanjangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_persegi_panjang)

        // 1. SETUP TOOLBAR OTOMATIS
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Persegi Panjang" // Judul halaman
            setDisplayHomeAsUpEnabled(true) // Tombol back otomatis
        }

        // 3. Inisialisasi Komponen
        val inputPanjang = findViewById<EditText>(R.id.inputPanjang)
        val inputLebar = findViewById<EditText>(R.id.inputLebar)
        val hasil = findViewById<TextView>(R.id.txtHasil)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        // 4. Logika Perhitungan
        btnHitung.setOnClickListener {
            val pString = inputPanjang.text.toString()
            val lString = inputLebar.text.toString()

            if (pString.isEmpty() || lString.isEmpty()) {
                Toast.makeText(this, "Input tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val p = pString.toDouble()
            val l = lString.toDouble()
            val luas = p * l

            hasil.text = "Luas = $luas"
        }
    }

    // 5. FUNGSI WAJIB: Agar tombol back di toolbar berfungsi
    override fun onSupportNavigateUp(): Boolean {
        onSupportNavigateUp()
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}