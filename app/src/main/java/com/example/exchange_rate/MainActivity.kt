package com.example.exchange_rate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.exchange_rate.data.api.ApiInterface
import com.example.exchange_rate.model.rateAlpha.RateAlpha
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = ApiInterface.create().getUser()
        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<RateAlpha> {
            override fun onResponse(call: Call<RateAlpha>?, response: Response<RateAlpha>?) {
             //   Log.d("log23", "Succes ${response?.body()?.USD?.first_name}")
//
            }

            override fun onFailure(call: Call<RateAlpha>?, t: Throwable?) {
                    Log.d("log23", "FAIl ${t?.message}")
            }
        })
    }

}