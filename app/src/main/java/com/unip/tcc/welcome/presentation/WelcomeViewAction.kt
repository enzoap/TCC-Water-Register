package com.unip.tcc.welcome.presentation

import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity

sealed class WelcomeViewAction {
    data class Success (val info: WaterConsumptionEntity): WelcomeViewAction()
    object Error: WelcomeViewAction()
    object ShowLoading: WelcomeViewAction()
    object HideLoading: WelcomeViewAction()
}