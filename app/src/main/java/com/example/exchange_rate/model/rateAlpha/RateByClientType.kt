package com.example.exchange_rate.model.rateAlpha

data class RateByClientType(
    val clientType: String,
    val ratesByType: List<RatesByType>
)