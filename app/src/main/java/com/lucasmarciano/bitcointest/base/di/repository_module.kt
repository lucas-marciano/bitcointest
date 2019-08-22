package com.lucasmarciano.bitcointest.base.di

import com.lucasmarciano.bitcointest.data.remote.TransactionApi
import com.lucasmarciano.bitcointest.data.remote.TransactionRepository
import com.lucasmarciano.bitcointest.data.remote.TransactionService
import org.koin.dsl.module.module
import retrofit2.Retrofit

val repositoryModule = module {
    factory { get<Retrofit>(BASE_SERVER).create(TransactionApi::class.java) }

    factory { TransactionService(api = get()) } bind TransactionRepository::class
}