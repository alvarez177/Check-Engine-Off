package com.checkengineoff.auth.login.domain.model

sealed interface AuthResult {
    data class Success(
        val user: AuthenticatedUser,
        val accessToken: String
    ) : AuthResult

    data class Failure(
        val error: AuthError
    ) : AuthResult
}