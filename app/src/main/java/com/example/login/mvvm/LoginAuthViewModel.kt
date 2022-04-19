package com.example.login.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginAuthViewModel : ViewModel() {
    companion object {
        const val NONE = 0
        const val USERNAME_EMPTY = 3
        const val PASSWORD_EMPTY = 4
        const val LOGIN_SUCCESS = 5
        const val TOO_LONG = 6
        const val NORMAL = 7
    }

    var uiEvent: MutableLiveData<Int> = MutableLiveData()
    var uiEventUsernameLength: MutableLiveData<Int> = MutableLiveData()

    var username: String? = null
    var password: String? = null

    fun onLoginBtnClick() {
        if (username.isNullOrEmpty()) {
            uiEvent.value = USERNAME_EMPTY
        }
        if (password.isNullOrEmpty()) {
            uiEvent.value = PASSWORD_EMPTY
        }
        if (!username.isNullOrEmpty() && !password.isNullOrEmpty()) {
            uiEvent.value = LOGIN_SUCCESS
        }

    }

}

