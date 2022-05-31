package com.example.login.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowsRepo {

    fun countDownFlow(): Flow<Int> = flow {
        var startValue = 10
        // emit(startValue)
        while (startValue > 0) {
            delay(1000)
            startValue--
            emit(startValue)
        }
    }

}