package com.checkengineoff.auth.login.data

import com.checkengineoff.auth.login.domain.model.AuthResult
import com.checkengineoff.auth.login.domain.model.AuthenticatedUser
import com.checkengineoff.auth.login.domain.model.Credential
import com.checkengineoff.auth.login.domain.repository.AuthRepository
import javax.inject.Inject

class AuthDataRepository @Inject constructor(): AuthRepository {

    override suspend fun doLogin(credential: Credential): AuthResult {
        return AuthResult.Success(
            user = AuthenticatedUser(
                id = "id",
                name = "Name",
                email = "email",
                cellphoneNumber = "cellPhoneNumber"
            ),
            accessToken = "token"
        )
    }
}