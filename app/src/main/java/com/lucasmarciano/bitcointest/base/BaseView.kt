package com.lucasmarciano.bitcointest.base

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}