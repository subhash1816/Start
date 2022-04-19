package com.example.login.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.login.interfaces.RetrofitServicePlayers
import com.example.login.model.Attributes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BasicViewModel : ViewModel() {
    val playerList = MutableLiveData<List<Attributes>>()
    var uiEvent = MutableLiveData<Int>()

    companion object {
        const val NEXTPAGE = 1
    }

    fun getAllPlayers() {
        val rfData = RetrofitServicePlayers.getInstance().playerlist()
        rfData.enqueue(object : Callback<List<Attributes>?> {
            override fun onResponse(
                call: Call<List<Attributes>?>,
                response: Response<List<Attributes>?>
            ) {
                if (response.isSuccessful) {
                    playerList.postValue(response.body())
                    Log.d("Success", playerList.toString())
                }
            }

            override fun onFailure(call: Call<List<Attributes>?>, t: Throwable) {
                Log.d("BasicFailure", "onFailure:${t.message} ")
            }
        })
    }

    fun onNextPageBtnClick() {
        uiEvent.value = NEXTPAGE
    }
}