package com.example.login.repository

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class FlowsRepo {

    fun countDownFlow() : Flow<Int> = flow {
        var startValue = 10
       // emit(startValue)
        while (startValue>0)
        {
            delay(1000)
            startValue--
            emit(startValue)
        }
    }

}