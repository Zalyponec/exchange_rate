package com.example.exchange_rate.data.api

import com.example.exchange_rate.model.rateAlpha.RateAlpha
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
        @GET("alfa-rates?currencyCode.in=USD,EUR,CHF,GBP&rateType.eq=makeCash&lastActualForDate.eq=true&clientType.eq=standardCC&date.lte=2022-04-10T02:45:34%2B03:00")
        suspend fun getMoney(): Response<RateAlpha>
}