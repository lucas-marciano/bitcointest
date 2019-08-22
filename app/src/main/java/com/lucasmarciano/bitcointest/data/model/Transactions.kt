package com.lucasmarciano.bitcointest.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Transactions(

    @SerializedName("x")
    var data: String = "",

    @SerializedName("y")
    var value: Float = 0f,

    var difference: Float = 0f
) : Parcelable
