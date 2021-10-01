package com.unip.tcc.core.retrofit

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class RetrofitModule {
    private val networkModules = module {
        single { RetrofitClient(context = androidContext()).newInstance() }
        single { HttpClient(retrofit = get()) }
    }

    fun load() {
        loadKoinModules(
            networkModules
        )
    }
}