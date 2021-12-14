package com.hosseinzafari.github.app.karak.feature_auth.domain.repository

import com.hosseinzafari.github.app.karak.feature_auth.domain.model.UserModel

/*

@created in 11/12/2021 - 9:43 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

interface UserAuthRepository {

    fun getUser(): UserModel

    fun signOut()

    fun userIsSigned(): Boolean

}