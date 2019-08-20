package com.lucasmarciano.bitcointest.data.remote

import com.lucasmarciano.bitcointest.data.model.Response
import com.lucasmarciano.bitcointest.data.model.ServiceResponse

interface TransactionRepository {
    suspend fun getTransactions(): ServiceResponse<Response>
}