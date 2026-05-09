package com.example.nasywa_core

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.nasywa_core.About.AboutFragment
import com.example.nasywa_core.Home.HomeFragment
import com.example.nasywa_core.Profile.ProfileFragment
import com.example.nasywa_core.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    // Inisialisasi binding di tingkat class
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Gunakan binding untuk set content view
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0) // Bottom 0 agar nav di paling bawah
            insets
        }

        // Tampilkan fragment Home saat pertama kali dibuka
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment()) // Ganti dengan nama class Fragment Home kamu
        }

        // Logika Klik Menu
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_about -> {
                    replaceFragment(AboutFragment())
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi bantuan untuk menukar Fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}