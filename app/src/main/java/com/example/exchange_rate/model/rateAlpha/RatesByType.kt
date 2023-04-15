package com.example.exchange_rate.model.rateAlpha

data class RatesByType(
    val lastActualRate: LastActualRate,
    val rateType: String,
    val ratesForPeriod: List<Any>
)