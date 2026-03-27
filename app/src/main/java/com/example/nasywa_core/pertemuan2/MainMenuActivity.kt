package com.example.nasywa_core.pertemuan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.R

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

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

