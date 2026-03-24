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

    fun onUsernameChanged(username: String) {
        sendEvent(
            event = UserRegistrationIntent.OnUserNameChanged(username)
        )
    }

    fun onUsernameFocusLost() {
        sendEvent(
            event = UserRegistrationIntent.OnUserFocusLost
        )
    }
}
