package com.auth.login.presentation.structure

import com.bold.core.presentation.Reducer

sealed interface LoginIntent : Reducer.ViewIntent {

    data class OnUsernameChanged(val username: String) : LoginIntent
    data class OnPasswordChanged(val password: String) : LoginIntent
    data class OnUsernameFocus(val isFocused: Boolean) : LoginIntent
    data class OnPasswordFocus(val isFocused: Boolean) : LoginIntent
    object OnLoginClicked : LoginIntent
}