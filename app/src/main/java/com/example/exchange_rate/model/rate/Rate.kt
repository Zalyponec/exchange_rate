package com.example.exchange_rate.model.rate

data class Rate(
    val rangeAmountBottom: Double,
    val rangeAmountUpper: Double,
    val rateBuy: Double,
    val rateSell: Double,
    val symbolBuy: String,
    val symbolSell: String
)