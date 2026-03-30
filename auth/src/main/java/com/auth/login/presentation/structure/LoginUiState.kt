package com.auth.login.presentation.structure

import com.bold.core.presentation.Reducer

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val usernameError: String? = null,
    val passwordError: String? = null,
    val hasPasswordBeenFocused: Boolean = false,
    val hasUsernameBeenFocused: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val enableLoginAction: Boolean = false
) : Reducer.ViewState