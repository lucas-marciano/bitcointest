package com.lucasmarciano.bitcointest.base.extensions

import java.text.SimpleDateFormat
import java.util.*


fun String.convertTimestampToDate(): String{
    val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    val netDate = Date(this)
    return sdf.format(netDate)
}
