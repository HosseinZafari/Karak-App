package com.hosseinzafari.github.app.karak.feature_auth.domain.utils

import com.hosseinzafari.github.app.karak.feature_auth.domain.model.UserModel

/*

@created in 11/12/2021 - 9:55 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

sealed class AuthState() {
    data class Success(
        val userModel: UserModel?
    ) : AuthState()

    data class Failed (
        val msg: String
    ) : AuthState()

    object Loading: AuthState()

    object NoRequested: AuthState()
}
