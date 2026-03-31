package com.checkengineoff.auth.register.presentation.structure

import com.checkengineoff.core.presentation.Reducer

sealed interface UserRegistrationIntent : Reducer.ViewIntent {
    data class OnUserNameChanged(val username: String) : UserRegistrationIntent
    data class OnEmailChanged(val email: String) : UserRegistrationIntent
    data class OnPhoneNumberChanged(val phoneNumber: String) : UserRegistrationIntent
    data class OnPasswordChanged(val password: String) : UserRegistrationIntent
    data class OnRegisterClick(val name: String, val email: String, val password: String) : UserRegistrationIntent
    data class OnUsernameFocus(val isFocused: Boolean) : UserRegistrationIntent
    data class OnEmailFocus(val isFocused: Boolean) : UserRegistrationIntent
    data class OnPhoneNumberFocus(val isFocused: Boolean) : UserRegistrationIntent
    data class OnPasswordFocus(val isFocused: Boolean) : UserRegistrationIntent
}