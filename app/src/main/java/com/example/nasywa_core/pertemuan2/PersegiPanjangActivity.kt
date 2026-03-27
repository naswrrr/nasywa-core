package com.example.nasywa_core.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.R
class PersegiPanjangActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persegi_panjang)

        val inputPanjang = findViewById<EditText>(R.id.inputPanjang)
        val inputLebar = findViewById<EditText>(R.id.inputLebar)
        val hasil = findViewById<TextView>(R.id.txtHasil)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        btnHitung.setOnClickListener {

            val p = inputPanjang.text.toString().toDoubleOrNull()
            val l = inputLebar.text.toString().toDoubleOrNull()

            if (p == null || l == null) {
                hasil.text = "Input tidak valid!"
                return@setOnClickListener
            }

            hasil.text = "Luas = ${p * l}"
        }
    }
}