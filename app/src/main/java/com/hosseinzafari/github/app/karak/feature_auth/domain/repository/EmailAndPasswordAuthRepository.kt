package com.hosseinzafari.github.app.karak.feature_auth.domain.repository

import com.hosseinzafari.github.app.karak.feature_auth.domain.utils.AuthState

/*

@created in 11/12/2021 - 9:52 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

interface EmailAndPasswordAuthRepository {

    fun registerUser(
        email: String ,
        password: String,
    ): AuthState

    fun loginUser(
        email: String ,
        password: String
    ): AuthState

}