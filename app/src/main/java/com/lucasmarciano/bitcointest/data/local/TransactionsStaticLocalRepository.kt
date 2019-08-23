package com.lucasmarciano.bitcointest.data.local

import com.lucasmarciano.bitcointest.data.model.ServiceResponse
import com.lucasmarciano.bitcointest.data.model.Transactions

private val list = mutableListOf<Transactions>()

class TransactionsStaticLocalRepository: TransactionsLocalRepository{


    override suspend fun add(trans: MutableList<Transactions>): ServiceResponse<*> {
        trans.forEach {
            val item = list.getItemId(it)
            if (item == -1) list.add(it)
            else list[item] = it
        }
        return ServiceResponse.OK
    }

    private fun List<Transactions>.getItemId(address: Transactions): Int {
        return this.indexOf(address)
    }

}