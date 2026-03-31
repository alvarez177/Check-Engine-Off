package com.checkengineoff.auth.login.domain.repository

import com.checkengineoff.auth.login.domain.model.AuthResult
import com.checkengineoff.auth.login.domain.model.Credential

interface AuthRepository {

    suspend fun doLogin(credential: Credential): AuthResult
}