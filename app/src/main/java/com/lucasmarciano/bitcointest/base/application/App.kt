package com.lucasmarciano.bitcointest.base.application

import android.app.Application
import com.lucasmarciano.bitcointest.base.di.dispatcherModule
import com.lucasmarciano.bitcointest.base.di.featureModule
import com.lucasmarciano.bitcointest.base.di.repositoryModule
import com.lucasmarciano.bitcointest.base.di.retrofitClientModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    private val modules = listOf(
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