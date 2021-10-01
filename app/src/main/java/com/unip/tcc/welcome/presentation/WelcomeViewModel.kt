package com.unip.tcc.welcome.presentation

import androidx.lifecycle.ViewModel

class WelcomeViewModel() : ViewModel() {

    fun writeScreen(name: String): String {
        return name
    }
}