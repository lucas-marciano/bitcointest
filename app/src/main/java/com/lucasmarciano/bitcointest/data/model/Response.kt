package com.lucasmarciano.bitcointest.data.model

data class Response(
    var status: String = "",
    var name: String = "",
    var unit: String = "",
    var period: String = "",
    var description: String = "",
    var values: List<Transactions> = emptyList()
)