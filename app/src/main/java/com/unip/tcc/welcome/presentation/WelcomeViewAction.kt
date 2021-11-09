package com.unip.tcc.welcome.presentation

import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity

sealed class WelcomeViewAction {
    data class Success (
        val info: WaterConsumptionEntity,
        val circleColor: Int,
        val stringRes: Int
        ): WelcomeViewAction()
    object Error: WelcomeViewAction()
    object ShowLoading: WelcomeViewAction()
    object HideLoading: WelcomeViewAction()
}