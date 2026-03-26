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

            is UserRegistrationIntent.OnUsernameFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasUsernameBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasUsernameBeenFocused = true
                    ) to null
                }

                if (!isFocused && hasBeenFocused) {
                    val error = validateUsername(previousState.username)

                    return previousState.copy(
                        usernameError = error
                    ) to null
                }

                return previousState to null
            }
        }
    }

    fun validateUsername(username: String): String? {
        return if (username.isBlank()) {
            "Username cannot be blank"
        } else null
    }
}