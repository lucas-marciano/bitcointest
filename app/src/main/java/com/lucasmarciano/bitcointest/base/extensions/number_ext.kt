package com.lucasmarciano.bitcointest.base.extensions

fun Number.toPercent() : String {
    val sb = StringBuilder()
    return sb.append(this).append("%").toString()

}