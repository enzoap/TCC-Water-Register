package com.unip.tcc.welcome.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unip.tcc.R
import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity
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

    val info: LiveData<WelcomeViewAction>
        get() = _info

    init {
        getInfo()
    }

    fun getInfo () {
        viewModelScope.launch {
            getWaterConsumption()
                .flowOn(Dispatchers.IO)
                .onStart { _info.postValue(WelcomeViewAction.ShowLoading) }
                .onCompletion { _info.postValue(WelcomeViewAction.HideLoading) }
                .catch { error -> error.handleErrors() }
                .collect { entity ->
                    success(entity)
                    Log.d("Response", entity.toString())
                }
        }
    }

    private fun success(entity: WaterConsumptionEntity) {
        if (entity.qtdToday.toFloat() > entity.qtdYesterday.toFloat()) {
            _info.value = WelcomeViewAction.Success(
                info = entity,
                circleColor = R.color.circle_error,
                stringRes = R.string.opa_temos_um_desperdicio
            )
        } else {
            _info.value = WelcomeViewAction.Success(
                info = entity,
                circleColor = R.color.green_principal,
                stringRes = R.string.parabens_voce_esta_economizando
            )
        }
    }

    private fun Throwable.handleErrors() {
        _info.postValue(WelcomeViewAction.Error)
    }
}