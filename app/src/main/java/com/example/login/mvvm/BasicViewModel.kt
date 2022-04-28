package com.example.login.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.interfaces.RetrofitInstanceApi
import com.example.login.model.Attributes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BasicViewModel : ViewModel() {
    val playerList = MutableLiveData<List<Attributes>>()
    var uiEvent = MutableLiveData<Int>()

    companion object {
        const val NEXTPAGE = 1
        const val TABLAYOUT = 2
    }
init {
    viewModelScope.launch {
        playerList.value = getAllPlayers()
    }
}

    suspend fun getAllPlayers() : List<Attributes> {
       return withContext(Dispatchers.IO) {
           RetrofitInstanceApi.getInstance().playerlist().body()!!
        }


        /*  rfData.enqueue(object : Callback<List<Attributes>?> {
              override fun onResponse(
                  call: Call<List<Attributes>?>,
                  response: Response<List<Attributes>?>
              ) {
                  if (response.isSuccessful) {
                      playerList.postValue(response.body())
                      Log.d("Success", "calling API")
                  }
              }

              override fun onFailure(call: Call<List<Attributes>?>, t: Throwable) {
                  Log.d("BasicFailure", "onFailure:${t.message} ")
              }
          })  */
    }

    fun onNextPageBtnClick() {
        uiEvent.value = NEXTPAGE
    }

    fun onTabLayoutBtnClick() {
        uiEvent.value = TABLAYOUT
    }
}