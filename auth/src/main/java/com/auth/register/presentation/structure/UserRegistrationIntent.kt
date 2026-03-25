package com.auth.register.presentation.structure

import com.bold.core.presentation.Reducer

sealed interface UserRegistrationIntent : Reducer.ViewIntent {
    data class OnUserNameChanged(val username: String) : UserRegistrationIntent
    data class OnEmailChanged(val email: String) : UserRegistrationIntent
    data class OnPasswordChanged(val password: String) : UserRegistrationIntent
    data class OnRegisterClick(val name: String, val email: String, val password: String) : UserRegistrationIntent

    object OnUserFocusLost : UserRegistrationIntent
    object OnUsernameFocusGained : UserRegistrationIntent
}