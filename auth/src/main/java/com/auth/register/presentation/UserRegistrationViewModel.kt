package com.auth.register.presentation

import com.auth.register.presentation.structure.UserRegistrationEffect
import com.auth.register.presentation.structure.UserRegistrationIntent
import com.auth.register.presentation.structure.UserRegistrationReducer
import com.auth.register.presentation.structure.UserRegistrationScreenState
import com.bold.core.presentation.viewmodel.BaseViewModel
import javax.inject.Inject

class UserRegistrationViewModel @Inject constructor() :
    BaseViewModel<UserRegistrationScreenState, UserRegistrationIntent, UserRegistrationEffect>(
        initialState = UserRegistrationScreenState(),
        reducer = UserRegistrationReducer()
    ) {

    fun onIntent(intent: UserRegistrationIntent) = sendEvent(intent)
}
