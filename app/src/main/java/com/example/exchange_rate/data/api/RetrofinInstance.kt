package com.example.exchange_rate.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofinInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://alfabank.ru/api/v1/scrooge/currencies/").addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}