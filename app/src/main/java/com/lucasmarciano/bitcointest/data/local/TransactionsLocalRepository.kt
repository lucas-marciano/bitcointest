package com.lucasmarciano.bitcointest.data.local

import com.lucasmarciano.bitcointest.data.model.ServiceResponse
import com.lucasmarciano.bitcointest.data.model.Transactions

interface TransactionsLocalRepository {
    suspend fun add(trans: MutableList<Transactions>): ServiceResponse<*>
}