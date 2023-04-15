package com.example.exchange_rate.model.rate

data class EUR(
    val lotSize: Double,
    val rateList: List<Rate>,
    val startDateTime: Long
)