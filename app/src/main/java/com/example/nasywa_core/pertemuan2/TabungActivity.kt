package com.example.nasywa_core.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nasywa_core.R

class TabungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabung)

        // 1. SETUP TOOLBAR OTOMATIS (Sesuai saran dosen)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Volume Tabung"
            setDisplayHomeAsUpEnabled(true) // Tombol back muncul otomatis
        }

        // 3. Inisialisasi Komponen
        val inputJari = findViewById<EditText>(R.id.inputJari)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val hasil = findViewById<TextView>(R.id.txtHasil)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        // 4. Logika Hitung
        btnHitung.setOnClickListener {
            val rString = inputJari.text.toString()
            val tString = inputTinggi.text.toString()

            if (rString.isEmpty() || tString.isEmpty()) {
                Toast.makeText(this, "Mohon isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val r = rString.toDouble()
            val t = tString.toDouble()

            // Rumus: PI * r^2 * t
            val volume = 3.14 * r * r * t
            hasil.text = "Volume = %.2f".format(volume)
        }
    }

    // 5. FUNGSI WAJIB: Agar tombol back di toolbar berfungsi
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}