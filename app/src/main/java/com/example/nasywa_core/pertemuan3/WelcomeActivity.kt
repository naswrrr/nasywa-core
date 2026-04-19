package com.example.nasywa_core.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.ActivityWelcomeBinding
import com.example.nasywa_core.pertemuan2.MainMenuActivity
import com.example.nasywa_core.pertemuan4.JobBoardActivity
import com.example.nasywa_core.pertemuan4.PortofolioActivity
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "PLANTSHOP CALCULATOR")
            intent.putExtra("EXTRA_DESC", "Hitung kebutuhan pot dan media tanammu.")
            startActivity(intent)
        }

        binding.btnJobBoard.setOnClickListener {
            val intent = Intent(this, JobBoardActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "PLANTSHOP CAREER")
            intent.putExtra("EXTRA_DESC", "Temukan karir impianmu di dunia tanaman.")
            startActivity(intent)
        }

        binding.btnPortofolio.setOnClickListener {
            val intent = Intent(this, PortofolioActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "PLANTSHOP PORTFOLIO")
            intent.putExtra("EXTRA_DESC", "Lihat koleksi project tanaman hias kami.")
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Yakin ingin kembali ke halaman login?")
                .setPositiveButton("Iya") { _, _ ->
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}