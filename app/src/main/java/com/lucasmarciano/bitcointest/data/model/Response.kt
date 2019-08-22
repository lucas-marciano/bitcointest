package com.lucasmarciano.bitcointest.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(
    var status: String = "",
    var name: String = "",
    var unit: String = "",
    var period: String = "",
    var description: String = "",
    var values: MutableList<Transactions> = mutableListOf()
) : Parcelable