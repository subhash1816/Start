package com.example.login.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.repository.FlowsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowsViewModel : ViewModel() {
    private var collectRepo: FlowsRepo? = FlowsRepo()
    // var uiEvent: MutableLiveData<Int> = MutableLiveData()

    private val _uiState = MutableStateFlow(10)
    val uiState = _uiState.asStateFlow()

    fun onCounterBtnClick() {
        Log.d("button", "button clicked")
        viewModelScope.launch {

            collectRepo?.countDownFlow()?.collect { count ->
                _uiState.value = count
                //        uiEvent.value = count
            }


        }
    }
}

