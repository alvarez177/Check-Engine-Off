package com.checkengineoff.auth.login.presentation

import com.checkengineoff.core.presentation.viewmodel.BaseViewModel
import com.checkengineoff.auth.login.presentation.structure.LoginEffect
import com.checkengineoff.auth.login.presentation.structure.LoginIntent
import com.checkengineoff.auth.login.presentation.structure.LoginReducer
import com.checkengineoff.auth.login.presentation.structure.LoginUiState

class LoginViewModel : BaseViewModel<LoginUiState, LoginIntent, LoginEffect>(
    initialState = LoginUiState(),
    reducer = LoginReducer()
) {

    fun onIntent(intent: LoginIntent) {
        sendEvent(intent)
    }
}