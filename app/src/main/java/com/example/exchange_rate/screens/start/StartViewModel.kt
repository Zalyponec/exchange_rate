package com.example.exchange_rate.screens.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchange_rate.data.api.ApiInterface
import com.example.exchange_rate.data.repository.Repository
import com.example.exchange_rate.model.rateAlpha.RateAlpha
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StartViewModel: ViewModel() {
    var MoneyList : MutableLiveData<Response<RateAlpha>> = MutableLiveData()

    fun getMoney() {

        viewModelScope.launch {
            var repo : Repository  = Repository()
            MoneyList.value = repo.getMoney()
        }
    }
}