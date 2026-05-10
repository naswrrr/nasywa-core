package com.example.nasywa_core.About

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.nasywa_core.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. SETUP TOOLBAR OTOMATIS
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbarAbout)

        activity.supportActionBar?.apply {
            title = "Tentang Program"
            setDisplayHomeAsUpEnabled(false) // Set true jika ingin tombol back, false jika tidak
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}