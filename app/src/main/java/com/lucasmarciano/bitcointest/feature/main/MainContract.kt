package com.lucasmarciano.bitcointest.feature.main

import com.lucasmarciano.bitcointest.base.BasePresenter
import com.lucasmarciano.bitcointest.base.BaseView
import com.lucasmarciano.bitcointest.data.model.Response

interface MainContract {
    interface View : BaseView<Presenter> {
        fun showLoading()
        fun hideLoading()
        fun onSuccessfulLoad(response: Response)
        fun onFailureLoad(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadTransactions()
    }
}