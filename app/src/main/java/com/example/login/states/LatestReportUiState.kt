package com.example.login.states

import com.example.login.model.Weather


sealed class LatestReportUiState
{
    object Loading : LatestReportUiState()
    data class Success(val weatherNews: Weather): LatestReportUiState()
    data class Failure(val exception: String?): LatestReportUiState()
}
