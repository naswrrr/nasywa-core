package com.example.nasywa_core.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.nasywa_core.WebViewActivity
import com.example.nasywa_core.databinding.FragmentHomeBinding // Pastikan binding fragment benar
import com.example.nasywa_core.pertemuan2.MainMenuActivity
import com.example.nasywa_core.pertemuan3.LoginActivity
import com.example.nasywa_core.pertemuan4.JobBoardActivity
import com.example.nasywa_core.pertemuan4.PortofolioActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Pindahkan semua logic OnClickListener dari WelcomeActivity ke sini

        binding.btnRumus.setOnClickListener {
            val intent = Intent(requireContext(), MainMenuActivity::class.java)
            startActivity(intent)
        }

        binding.btnJobBoard.setOnClickListener {
            val intent = Intent(requireContext(), JobBoardActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "PlantShop Career")
            intent.putExtra("EXTRA_DESC", "Wujudkan passion menanammu menjadi karir yang luar biasa")
            startActivity(intent)
        }

        binding.btnWebView.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnPortofolio.setOnClickListener {
            val intent = Intent(requireContext(), PortofolioActivity::class.java)
            intent.putExtra("EXTRA_JUDUL", "PlantShop Portfolio")
            intent.putExtra("EXTRA_DESC", "Lihat koleksi project tanaman hias kami")
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Yakin ingin keluar dari akun Bina Desa?")
                .setPositiveButton("Iya") { _, _ ->
                    val sharedPref = requireActivity().getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
                    sharedPref.edit().putBoolean("isLogin", false).apply()

                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}