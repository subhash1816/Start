package com.example.login.repository

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class FlowsFakeRepo {
     val _uiState = MutableStateFlow(10)


    fun countDownFlow() : Flow<Int> = flow {
        var startValue = 10
        // emit(startValue)
        while (startValue>0)
        {
            delay(1000)
            startValue--
            Log.d("button", "countDownFlow:$startValue ")
            _uiState.emit(startValue)
        }
    }
}