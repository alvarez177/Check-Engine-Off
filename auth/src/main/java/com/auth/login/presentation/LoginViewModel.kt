package com.auth.login.presentation

import com.auth.login.presentation.structure.LoginEffect
import com.auth.login.presentation.structure.LoginIntent
import com.auth.login.presentation.structure.LoginReducer
import com.auth.login.presentation.structure.LoginUiState
import com.bold.core.presentation.viewmodel.BaseViewModel

class LoginViewModel : BaseViewModel<LoginUiState, LoginIntent, LoginEffect>(
    initialState = LoginUiState(),
    reducer = LoginReducer()
) {

    fun onIntent(intent: LoginIntent) {
        sendEvent(intent)
    }
}