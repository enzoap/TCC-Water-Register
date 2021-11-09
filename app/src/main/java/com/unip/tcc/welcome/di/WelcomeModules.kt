package com.unip.tcc.welcome.di

import com.unip.tcc.core.retrofit.HttpClient
import com.unip.tcc.welcome.data.api.WaterConsumption
import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSource
import com.unip.tcc.welcome.data.datasource.WaterConsumptionDataSourceImpl
import com.unip.tcc.welcome.domain.repository.WaterRepositoryImpl
import com.unip.tcc.welcome.domain.usecase.GetWaterConsumption
import com.unip.tcc.welcome.presentation.WelcomeViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

@InternalCoroutinesApi
class WelcomeModules {
    private val presentationModules =  module {
        viewModel { WelcomeViewModel(
            getWaterConsumption = GetWaterConsumption(
                waterRepository = WaterRepositoryImpl(
                    waterConsumptionDataSource = get()
                )
            )
        ) }
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