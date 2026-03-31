package com.checkengineoff.auth.register.presentation.structure

import com.checkengineoff.core.presentation.Reducer

data class UserRegistrationScreenState(
    val isLoading: Boolean = false,
    val username: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val enableRegisterAction: Boolean = false,
    val hasUsernameBeenFocused: Boolean = false,
    val hasEmailBeenFocused: Boolean = false,
    val hasPhoneNumberBeenFocused: Boolean = false,
    val hasPasswordBeenFocused: Boolean = false,
    val usernameError: String? = null,
    val emailError: String? = null,
    val phoneNumberError: String? = null,
    val passwordError: String? = null
) : Reducer.ViewState
