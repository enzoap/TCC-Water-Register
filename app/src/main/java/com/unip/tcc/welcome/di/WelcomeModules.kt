package com.unip.tcc.welcome.di

import com.unip.tcc.core.retrofit.HttpClient
import com.unip.tcc.welcome.data.api.WaterConsumption
import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSource
import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSourceImpl
import com.unip.tcc.welcome.presentation.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class WelcomeModules {
    private val presentationModules =  module {
        viewModel { WelcomeViewModel() }
    }

    private val networkModules = module {
        factory { get<HttpClient>().create(WaterConsumption::class.java) }
    }

    private val dataModules = module {
        factory<WaterConsumptionDataSource> {
            WaterConsumptionDataSourceImpl(waterConsumption = get())
        }
    }

    fun load() {
        loadKoinModules(
            listOf(
                presentationModules,
                networkModules,
                dataModules
            )
        )
    }
}