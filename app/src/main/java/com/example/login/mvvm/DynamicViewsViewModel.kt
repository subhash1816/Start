package com.example.login.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.interfaces.RetrofitInstanceApi
import com.example.login.model.MultiViews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DynamicViewsViewModel : ViewModel() {
    var dynamicViews = MutableLiveData<List<MultiViews>>()

init {
    viewModelScope.launch {
        dynamicViews.value = getAllViews()
    }
}
    suspend fun getAllViews() : List<MultiViews> {

        return withContext(Dispatchers.IO) {
                RetrofitInstanceApi.getInstance().multilist().body()!!
        }

    }


}