package com.example.login.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.interfaces.RetrofitInstanceApi
import com.example.login.model.Attributes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BasicViewModel : ViewModel() {
    val playerList = MutableLiveData<List<Attributes>>()
    var uiEvent = MutableLiveData<Int>()
var html = "<b>Welcome </b>"
    companion object {
        const val NEXTPAGE = 1
        const val TABLAYOUT = 2
    }

    init {
        viewModelScope.launch {
            playerList.value = getAllPlayers()

        }
    }

    suspend fun getAllPlayers(): List<Attributes> {

        return withContext(Dispatchers.IO) {

            RetrofitInstanceApi.getInstance().playerlist().body()!!
        }
    }

    fun onNextPageBtnClick() {
        uiEvent.value = NEXTPAGE
    }

    fun onTabLayoutBtnClick() {
        uiEvent.value = TABLAYOUT
    }
}