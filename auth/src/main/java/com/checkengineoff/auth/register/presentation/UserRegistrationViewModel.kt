package com.checkengineoff.auth.register.presentation

import com.checkengineoff.core.presentation.viewmodel.BaseViewModel
import com.checkengineoff.auth.register.presentation.structure.UserRegistrationEffect
import com.checkengineoff.auth.register.presentation.structure.UserRegistrationIntent
import com.checkengineoff.auth.register.presentation.structure.UserRegistrationReducer
import com.checkengineoff.auth.register.presentation.structure.UserRegistrationScreenState
import javax.inject.Inject

class UserRegistrationViewModel @Inject constructor() :
    BaseViewModel<UserRegistrationScreenState, UserRegistrationIntent, UserRegistrationEffect>(
        initialState = UserRegistrationScreenState(),
        reducer = UserRegistrationReducer()
    ) {

    fun onIntent(intent: UserRegistrationIntent) = sendEvent(intent)
}
