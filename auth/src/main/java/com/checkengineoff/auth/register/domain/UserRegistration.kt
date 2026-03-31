package com.checkengineoff.auth.register.domain

data class UserRegistration(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val password: String
)