package com.checkengineoff.auth.login.domain.model

data class AuthenticatedUser(
    val id: String,
    val name: String,
    val email: String,
    val cellphoneNumber: String
)