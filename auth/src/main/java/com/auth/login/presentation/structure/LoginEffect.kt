package com.auth.login.presentation.structure

import com.bold.core.Reducer

sealed interface LoginEffect : Reducer.ViewEffect {
    object NavigateToHome : LoginEffect
    data class ShowError(val message: String) : LoginEffect
}