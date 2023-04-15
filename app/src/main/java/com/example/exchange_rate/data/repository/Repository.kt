package com.example.exchange_rate.data.repository

import com.example.exchange_rate.data.api.RetrofinInstance
import com.example.exchange_rate.model.rateAlpha.RateAlpha
import retrofit2.Response


class Repository {

    suspend fun getMoney() : Response<RateAlpha> {
        return RetrofinInstance.api.getMoney()
    }
}