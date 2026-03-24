package com.auth.register.presentation.structure

import com.bold.core.presentation.Reducer

sealed interface UserRegistrationEffect : Reducer.ViewEffect {
    data object NavigateToDashboard : UserRegistrationEffect
}