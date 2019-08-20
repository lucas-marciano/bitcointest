package com.lucasmarciano.bitcointest.base.application

import android.app.Application
import com.lucasmarciano.bitcointest.base.di.*
import org.koin.android.ext.android.startKoin

class App : Application() {

    private val modules = listOf(
        appModule,
        featureModule,
        dispatcherModule,
        retrofitClientModule,
        repositoryModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin(this, modules)
    }
}