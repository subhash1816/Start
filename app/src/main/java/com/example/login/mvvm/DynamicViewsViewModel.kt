package com.example.login.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.interfaces.RetrofitServicePlaces
import com.example.login.model.MultiViews
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DynamicViewsViewModel : ViewModel() {
    var dynamicViews = MutableLiveData<List<MultiViews>>()


    fun getAllViews() {
        val rfData = RetrofitServicePlaces.getInstance().multilist()
        rfData.enqueue(object : Callback<List<MultiViews>?> {
            override fun onResponse(
                call: Call<List<MultiViews>?>,
                response: Response<List<MultiViews>?>
            ) {
                if (response.isSuccessful) {
                    dynamicViews.postValue(response.body())

                }
            }

            override fun onFailure(call: Call<List<MultiViews>?>, t: Throwable) {
                Log.d("BasicFailure", "onFailure:${t.message} ")
            }
        })
    }


}