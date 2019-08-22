package com.lucasmarciano.bitcointest.base.utils

import com.lucasmarciano.bitcointest.BuildConfig

object Logger {
    val DEBUG = BuildConfig.DEBUG
    private val MAX_TAG_LENGTH = 23
    private val CLASS_STACK_ITEM = 3

    /**
     * Returns A TAG for the caller class.
     * @return The Tag to be used for logs.
     */
    fun getTag(): String {
        val caller = Thread.currentThread().stackTrace[CLASS_STACK_ITEM]
        var tag = caller.className
        val lastDot = tag.lastIndexOf('.')

        if (lastDot > 0) {
            tag = tag.substring(lastDot + 1)
        }

        if (tag.length > MAX_TAG_LENGTH) {
            tag = tag.substring(0, MAX_TAG_LENGTH)
        }

        return tag
    }
}