package com.dicodingapp.moviecatalogue.utils

import java.text.NumberFormat
import java.util.*

object Converting {
    fun formatDollar(number: String): String {
        return "$" + formatNumber(number)
    }

    private fun formatNumber(number: String): String {
        return NumberFormat.getInstance(Locale.ENGLISH).format(number.toDouble())
    }
}