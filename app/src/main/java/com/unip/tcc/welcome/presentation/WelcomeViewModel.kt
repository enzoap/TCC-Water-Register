package com.unip.tcc.welcome.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unip.tcc.welcome.domain.usecase.GetWaterConsumption
import kotlinx.coroutines.launch

class WelcomeViewModel(
    private val getWaterConsumption: GetWaterConsumption
    ) : ViewModel() {
    init {

    }
    private fun getInfo (){
        viewModelScope.launch {
            getWaterConsumption()
        }
    }
}