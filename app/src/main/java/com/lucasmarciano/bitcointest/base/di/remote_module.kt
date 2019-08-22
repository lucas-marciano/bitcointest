package com.lucasmarciano.bitcointest.base.di

import com.lucasmarciano.bitcointest.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

const val BASE_SERVER = "BASE_SERVER"

val logging = HttpLoggingInterceptor()

val retrofitClientModule = module {
    logging.level = HttpLoggingInterceptor.Level.BODY

    single(BASE_SERVER) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(get())
            .build()
    } bind Retrofit::class

    single {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    } bind OkHttpClient::class
}