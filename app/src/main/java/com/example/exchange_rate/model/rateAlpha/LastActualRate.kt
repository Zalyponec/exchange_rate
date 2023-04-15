package com.example.exchange_rate.model.rateAlpha

data class LastActualRate(
    val buy: Buy,
    val date: String,
    val sell: Sell
)