package com.example.login.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.model.Weather
import com.example.login.repository.FlowsRepo
import com.example.login.states.LatestReportUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class FlowsViewModel : ViewModel() {
    lateinit var place: String

    lateinit var collectRepo: FlowsRepo

    // var uiEvent: MutableLiveData<Int> = MutableLiveData()
    fun place(place: String) {
        this.place = place
    }

    private val _uiStateFlowEvents: MutableSharedFlow<LatestReportUiState> = MutableSharedFlow()
    val uiStateFlowEvents: SharedFlow<LatestReportUiState> = _uiStateFlowEvents.asSharedFlow()

    fun onGoBtnClick() {
        if (place.isNotEmpty()) {
            collectRepo = FlowsRepo(place)
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    handleResponse(collectRepo.weatherCall())
                }catch (exception : Exception ){

                }

            }
        }
    }

    private suspend fun handleResponse(addWeatherInformation: Weather?) {

            if (addWeatherInformation?.loc != null) {
                Log.d("subhash--", "${addWeatherInformation.loc}")
                _uiStateFlowEvents.emit(LatestReportUiState.Success(addWeatherInformation))
            } else {
                Log.d("subhash", "${addWeatherInformation?.error?.message}")

                _uiStateFlowEvents.emit(LatestReportUiState.Failure(addWeatherInformation))
            }

        }


    }

  /*  private suspend fun handleFailResponse(exception: Exception) {
        _uiStateFlowEvents.emit(LatestReportUiState.Failure(exception.cause.toString()))
    } */

