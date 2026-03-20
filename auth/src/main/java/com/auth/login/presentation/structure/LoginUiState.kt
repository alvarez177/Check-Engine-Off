package com.auth.login.presentation.structure

import com.bold.core.presentation.Reducer

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoginEnabled: Boolean = false
) : Reducer.ViewState