package com.auth.login.domain.repository

import com.auth.login.domain.model.AuthResult
import com.auth.login.domain.model.Credential

interface AuthRepository {

    suspend fun doLogin(credential: Credential): AuthResult
}