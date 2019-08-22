package com.lucasmarciano.bitcointest.base.di

import com.google.gson.GsonBuilder
import com.lucasmarciano.bitcointest.feature.main.MainContract
import com.lucasmarciano.bitcointest.feature.main.MainPresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module
import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    factory { (view: MainContract.View) ->
        MainPresenter(
            view = view,
            repository = get(),
            dispatcherContext = get()
        )
    } bind MainContract.Presenter::class
}

val featureModule = module {
    single {
        GsonConverterFactory.create(GsonBuilder().create())
    } bind Converter.Factory::class
}

val dispatcherModule = module {
    factory { Dispatchers.Main as CoroutineDispatcher }
}