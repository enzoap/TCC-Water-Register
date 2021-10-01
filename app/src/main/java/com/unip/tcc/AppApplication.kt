package com.unip.tcc

import android.app.Application
import com.unip.tcc.core.retrofit.RetrofitModule
import com.unip.tcc.welcome.di.WelcomeModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            RetrofitModule().load()
            WelcomeModules().load()
        }
    }
}