package com.example.login.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.model.Weather
import com.example.login.repository.FlowsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowsViewModel : ViewModel() {
    lateinit var place: String

    lateinit var collectRepo: FlowsRepo

    // var uiEvent: MutableLiveData<Int> = MutableLiveData()
    fun place(place: String) {
        this.place = place
    }

    private val _uiState = MutableStateFlow<Weather>(Weather(null, null))
    val uiState = _uiState.asStateFlow()

    fun onGoBtnClick() {
        if (place.toString().isNotEmpty()) {
            collectRepo = FlowsRepo(place)
            viewModelScope.launch {
                collectRepo.countDownFlow().collect { Report ->
                    _uiState.value = Report
                    //        uiEvent.value = count
                }
            }
        }

    }
}

/* sealed class LatestReportUiState {
    data class Success(val news: List<WeatherInformation>): LatestReportUiState()
    data class Error(val exception: Throwable): LatestReportUiState()
} */