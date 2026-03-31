package com.checkengineoff.auth.login.presentation.structure

import com.checkengineoff.core.presentation.Reducer

class LoginReducer : Reducer<LoginUiState, LoginIntent, LoginEffect> {

    override fun reduce(
        previousState: LoginUiState,
        intent: LoginIntent
    ): Pair<LoginUiState, LoginEffect?> {
        return when(intent) {
            is LoginIntent.OnUsernameChanged -> {
                previousState.copy(
                    username = intent.username,
                    usernameError = if (intent.username.isNotEmpty()) null else previousState.usernameError,
                    enableLoginAction = intent.username.isNotEmpty() && previousState.password.isNotEmpty()
                ) to null
            }

            is LoginIntent.OnPasswordChanged -> {
                previousState.copy(
                    password = intent.password,
                    passwordError = if (intent.password.isNotEmpty()) null else previousState.passwordError,
                    enableLoginAction = intent.password.isNotEmpty() && previousState.username.isNotEmpty()
                ) to null
            }

            is LoginIntent.OnLoginClicked -> {
                previousState.copy(
                    isLoading = true,
                ) to LoginEffect.NavigateToHome
            }

            is LoginIntent.OnPasswordFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasPasswordBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasPasswordBeenFocused = true
                    ) to null
                }

                if (!isFocused && hasBeenFocused) {
                    val error = getEmptyMessageForRequiredInformation(previousState.password, "Password")

                    return previousState.copy(
                        passwordError = error
                    ) to null
                }

                return previousState to null
            }
            is LoginIntent.OnUsernameFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasUsernameBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasUsernameBeenFocused = true
                    ) to null
                }

                if (!isFocused && hasBeenFocused) {
                    val error = getEmptyMessageForRequiredInformation(previousState.username, "Username")

                    return previousState.copy(
                        usernameError = error
                    ) to null
                }

                return previousState to null
            }
        }
    }

    fun getEmptyMessageForRequiredInformation(value: String, specificDate: String): String? {
        return if (value.isEmpty()) {
            "$specificDate cannot be blank"
        } else null
    }
}