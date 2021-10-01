package com.unip.tcc.welcome.di

import com.unip.tcc.core.retrofit.HttpClient
import com.unip.tcc.welcome.data.api.WaterComsuptionOneDay
import com.unip.tcc.welcome.presentation.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class WelcomeModules {
    private val presentationModules =  module {
        viewModel { WelcomeViewModel() }
    }

    private val networkModules = module {
        factory { get<HttpClient>().create(WaterComsuptionOneDay::class.java) }
    }

    fun load() {
        loadKoinModules(
            listOf(
                presentationModules,
                networkModules
            )
        )
    }
}