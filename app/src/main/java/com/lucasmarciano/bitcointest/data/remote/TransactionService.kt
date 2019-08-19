package com.lucasmarciano.bitcointest.data.remote

import com.lucasmarciano.bitcointest.base.extensions.awaitResult
import com.lucasmarciano.bitcointest.data.model.Response
import com.lucasmarciano.bitcointest.data.model.ServiceResponse

class TransactionService(private val api: TransactionApi): TransactionRepository {

    override suspend fun getTransactions(): ServiceResponse<Response> {
        return api.getTransactions().awaitResult()
    }
}