package com.example.exchange_rate.data.api

import com.example.exchange_rate.model.rateAlpha.RateAlpha
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("alfa-rates?currencyCode.in=USD,EUR,CHF,GBP&rateType.eq=makeCash&lastActualForDate.eq=true&clientType.eq=standardCC&date.lte=2022-04-10T02:45:34%2B03:00")
    fun getUser() : Call<RateAlpha>

    companion object {

      private  var BASE_URL = "https://alfabank.ru/api/v1/scrooge/currencies/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}