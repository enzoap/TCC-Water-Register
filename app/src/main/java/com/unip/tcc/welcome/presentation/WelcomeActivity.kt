package com.unip.tcc.welcome.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unip.tcc.databinding.ActivityWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeActivity : AppCompatActivity() {
    private val welcomeViewMode: WelcomeViewModel by viewModel()
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.text.text = welcomeViewMode.writeScreen("enzo")
    }
}