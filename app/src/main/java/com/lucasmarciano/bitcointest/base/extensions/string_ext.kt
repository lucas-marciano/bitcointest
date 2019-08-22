package com.lucasmarciano.bitcointest.base.extensions

import java.text.SimpleDateFormat
import java.util.*


fun String.convertTimestampToDate(): String {
    return try {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US)
        val netDate = Date(this.toLong() * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}
