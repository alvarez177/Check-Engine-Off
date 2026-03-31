package com.checkengineoff.auth.register.presentation.structure

import android.util.Patterns
import com.checkengineoff.core.presentation.Reducer

class UserRegistrationReducer :
    Reducer<UserRegistrationScreenState, UserRegistrationIntent, UserRegistrationEffect> {

    override fun reduce(
        previousState: UserRegistrationScreenState,
        intent: UserRegistrationIntent
    ): Pair<UserRegistrationScreenState, UserRegistrationEffect?> {
        return when (intent) {
            is UserRegistrationIntent.OnUserNameChanged -> {
                previousState.copy(
                    username = intent.username,
                    usernameError = if (intent.username.isNotEmpty()) null else previousState.usernameError,
                    enableRegisterAction = intent.username.isNotEmpty() && previousState.email.isNotEmpty() && previousState.phoneNumber.isNotEmpty() && previousState.password.isNotEmpty()
                ) to null
            }

            is UserRegistrationIntent.OnEmailChanged -> {
                val email = intent.email
                val isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                previousState.copy(
                    email = email,
                    emailError = if (email.isNotEmpty() && !isValidEmail) "Invalid email" else null,
                    enableRegisterAction = previousState.username.isNotEmpty() && intent.email.isNotEmpty() && previousState.phoneNumber.isNotEmpty() && previousState.password.isNotEmpty()
                ) to null
            }

            is UserRegistrationIntent.OnPhoneNumberChanged -> {
                previousState.copy(
                    phoneNumber = intent.phoneNumber,
                    phoneNumberError = if (intent.phoneNumber.isNotEmpty()) null else previousState.phoneNumberError,
                    enableRegisterAction = previousState.username.isNotEmpty() && previousState.email.isNotEmpty() && intent.phoneNumber.isNotEmpty() && previousState.password.isNotEmpty()
                ) to null
            }

            is UserRegistrationIntent.OnPasswordChanged -> {
                previousState.copy(
                    password = intent.password,
                    passwordError = if (intent.password.isNotEmpty()) null else previousState.passwordError,
                    enableRegisterAction = previousState.username.isNotEmpty() && previousState.email.isNotEmpty() && previousState.phoneNumber.isNotEmpty() && intent.password.isNotEmpty()
                ) to null
            }

            is UserRegistrationIntent.OnRegisterClick -> {
                previousState.copy(
                    isLoading = false
                ) to UserRegistrationEffect.NavigateToDashboard
            }

            is UserRegistrationIntent.OnUsernameFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasUsernameBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasUsernameBeenFocused = true
                    ) to null
                }

                if (!isFocused && hasBeenFocused) {
                    val error = getEmptyMessageForRequiredInformation(previousState.username, "Username")

                    return previousState.copy(
                        usernameError = error
                    ) to null
                }

                return previousState to null
            }

            is UserRegistrationIntent.OnEmailFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasEmailBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasEmailBeenFocused = true
                    ) to null
                }

                if (!isFocused && previousState.email.isEmpty() && hasBeenFocused) {
                    val error = getEmptyMessageForRequiredInformation(previousState.email, "Email")

                    return previousState.copy(
                        emailError = error
                    ) to null
                }

                return previousState to null
            }

            is UserRegistrationIntent.OnPhoneNumberFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasPhoneNumberBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasPhoneNumberBeenFocused = true
                    ) to null
                }

                if (!isFocused && hasBeenFocused) {
                    val error = getEmptyMessageForRequiredInformation(previousState.phoneNumber, "Phone number")

                    return previousState.copy(
                        phoneNumberError = error
                    ) to null
                }

                return previousState to null

            }

            is UserRegistrationIntent.OnPasswordFocus -> {
                val isFocused = intent.isFocused
                val hasBeenFocused = previousState.hasPasswordBeenFocused

                if (isFocused && !hasBeenFocused) {
                    return previousState.copy(
                        hasPasswordBeenFocused = true
                    ) to null
                }

                if (!isFocused && hasBeenFocused) {
                    val error = getEmptyMessageForRequiredInformation(previousState.password, "Password")

                    return previousState.copy(
                        passwordError = error
                    ) to null
                }

                return previousState to null

            }
        }
    }

    fun getEmptyMessageForRequiredInformation(value: String, specificDate: String): String? {
        return if (value.isEmpty()) {
            "$specificDate cannot be blank"
        } else null
    }
}