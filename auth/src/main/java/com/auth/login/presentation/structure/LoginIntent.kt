package com.auth.login.presentation.structure

import com.bold.core.presentation.Reducer

sealed interface LoginIntent : Reducer.ViewIntent {

    data class UsernameChanged(val username: String) : LoginIntent

    data class PasswordChanged(val password: String) : LoginIntent

    object LoginClicked : LoginIntent
}