package com.auth.login.data

import com.auth.login.domain.model.AuthResult
import com.auth.login.domain.model.AuthenticatedUser
import com.auth.login.domain.model.Credential
import com.auth.login.domain.repository.AuthRepository
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