package com.example.login.mvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.repository.FlowsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowsViewModel : ViewModel() {
   private var collectRepo: FlowsRepo? = FlowsRepo()
    var uiEvent: MutableLiveData<Int> = MutableLiveData()

    companion object {
        const val COUNTERDECREMENT = 1
        const val TABLAYOUT = 2
    }



    fun onCounterBtnClick() {
        Log.d("button" ,"button clicked")
        viewModelScope.launch {
            collectRepo?.countDownFlow()?.collect { count ->
                Log.d("button", "$count")

                uiEvent.value = count
            }

        }
    }
}

