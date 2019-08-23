package com.lucasmarciano.bitcointest.feature.main

import com.lucasmarciano.bitcointest.base.extensions.launch
import com.lucasmarciano.bitcointest.data.local.TransactionsLocalRepository
import com.lucasmarciano.bitcointest.data.model.Transactions
import com.lucasmarciano.bitcointest.data.model.whenever
import com.lucasmarciano.bitcointest.data.remote.TransactionRepository
import kotlinx.coroutines.CoroutineDispatcher

class MainPresenter(
    override var view: MainContract.View,
    private val repository: TransactionRepository,
    private val localRepository: TransactionsLocalRepository,
    private val dispatcherContext: CoroutineDispatcher
): MainContract.Presenter {

    override fun saveAll(transactions: MutableList<Transactions>) {
        dispatcherContext.launch {
            localRepository.add(transactions)
        }
    }

    override fun loadTransactions() {
        view.showLoading()

        dispatcherContext.launch {
            repository.getTransactions().whenever(
                isBody = { items ->
                    view.hideLoading()
                    view.onSuccessfulLoad(items)
                },
                isError = { msg ->
                    view.hideLoading()
                    view.onFailureLoad(msg)
                }
            )
        }
    }
}