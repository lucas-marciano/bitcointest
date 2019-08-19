package com.lucasmarciano.bitcointest.base.di

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
}

val featureModule = module {
    single {
        GsonConverterFactory.create(GsonBuilder().create())
    } bind Converter.Factory::class
}

val dispatcherModule = module {
    factory { Dispatchers.Main }
}