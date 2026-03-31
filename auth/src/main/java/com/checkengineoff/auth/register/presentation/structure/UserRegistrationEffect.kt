package com.checkengineoff.auth.register.presentation.structure

import com.checkengineoff.core.presentation.Reducer

sealed interface UserRegistrationEffect : Reducer.ViewEffect {
    data object NavigateToDashboard : UserRegistrationEffect
}