package com.unip.tcc.welcome.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unip.tcc.welcome.domain.usecase.GetWaterConsumption
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class WelcomeViewModel(
    private val getWaterConsumption: GetWaterConsumption
    ) : ViewModel() {
    private val _info = MutableLiveData<WelcomeViewAction>()

    val info: LiveData<WelcomeViewAction> = _info

    init {
        getInfo()
    }

    private fun getInfo () {
        viewModelScope.launch {
            getWaterConsumption()
                .flowOn(Dispatchers.IO)
                .onStart { _info.postValue(WelcomeViewAction.ShowLoading) }
                .onCompletion { _info.postValue(WelcomeViewAction.HideLoading) }
                .collect { entity ->
                    _info.postValue(WelcomeViewAction.Success(
                        entity
                    ))
                }
        }
    }
}