package com.auth.register.presentation.structure

import com.bold.core.presentation.Reducer

class UserRegistrationReducer :
    Reducer<UserRegistrationScreenState, UserRegistrationIntent, UserRegistrationEffect> {

    override fun reduce(
        previousState: UserRegistrationScreenState,
        intent: UserRegistrationIntent
    ): Pair<UserRegistrationScreenState, UserRegistrationEffect?> {
        return when (intent) {
            is UserRegistrationIntent.OnUserNameChanged -> {
                previousState.copy(
                    username = intent.username,
                    usernameError = if (intent.username.isNotEmpty()) null else previousState.usernameError
                ) to null
            }
            is UserRegistrationIntent.OnEmailChanged -> {
                previousState.copy(
                    email = intent.email
                ) to null
            }
            is UserRegistrationIntent.OnPasswordChanged -> {
                previousState.copy(
                    password = intent.password
                ) to null
            }
            is UserRegistrationIntent.OnRegisterClick -> {
                previousState.copy(
                    isLoading = false
                ) to UserRegistrationEffect.NavigateToDashboard
            }

            UserRegistrationIntent.OnUserFocusLost -> {
                if (previousState.username.isBlank()) {
                    previousState.copy(
                        usernameError = "Username cannot be blank"
                    ) to null
                } else {
                    previousState.copy(
                        usernameError = null
                    ) to null
                }
            }

            UserRegistrationIntent.OnUsernameFocusGained -> {
                previousState.copy(
                    hasUsernameBeenFocused = true
                ) to null
            }
        }
    }
}