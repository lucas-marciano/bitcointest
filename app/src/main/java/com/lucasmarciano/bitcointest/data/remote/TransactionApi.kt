package com.lucasmarciano.bitcointest.data.remote

import com.lucasmarciano.bitcointest.data.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface TransactionApi {
    @GET("timespan=5weeks&rollingAverage=8hours&format=json")
    fun getTransactions(): Call<Response>
}