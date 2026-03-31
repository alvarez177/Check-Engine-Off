package com.checkengineoff.auth.login.domain.usecase

import com.checkengineoff.auth.login.domain.model.AuthResult
import com.checkengineoff.auth.login.domain.model.Credential
import com.checkengineoff.auth.login.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(credential: Credential): AuthResult {
        return authRepository.doLogin(credential)
    }
}