package com.example.nasywa_core.pertemuan2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.R

class TabungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabung)

        val inputJari = findViewById<EditText>(R.id.inputJari)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val hasil = findViewById<TextView>(R.id.txtHasil)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        btnHitung.setOnClickListener {

            val r = inputJari.text.toString().toDoubleOrNull()
            val t = inputTinggi.text.toString().toDoubleOrNull()

            if (r == null || t == null) {
                hasil.text = "Input tidak valid!"
                return@setOnClickListener
            }

            hasil.text = "Volume = ${3.14 * r * r * t}"
        }
    }
}