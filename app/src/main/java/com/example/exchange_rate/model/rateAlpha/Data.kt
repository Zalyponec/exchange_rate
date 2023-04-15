package com.example.exchange_rate.model.rateAlpha

data class Data(
    val currencyCode: String,
    val rateByClientType: List<RateByClientType>
)