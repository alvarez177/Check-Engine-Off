package com.auth.login.presentation.structure

import com.bold.core.presentation.Reducer

class LoginReducer : Reducer<LoginUiState, LoginIntent, LoginEffect> {

    override fun reduce(
        previousState: LoginUiState,
        intent: LoginIntent
    ): Pair<LoginUiState, LoginEffect?> {
        return when(intent) {
            is LoginIntent.UsernameChanged -> {
                previousState.copy(
                    username = intent.username,
                ) to null
            }

            is LoginIntent.PasswordChanged -> {
                previousState.copy(
                    password = intent.password,
                ) to null
            }

            is LoginIntent.LoginClicked -> {
                previousState.copy(
                    isLoading = true,
                ) to LoginEffect.NavigateToHome
            }
        }
    }
}