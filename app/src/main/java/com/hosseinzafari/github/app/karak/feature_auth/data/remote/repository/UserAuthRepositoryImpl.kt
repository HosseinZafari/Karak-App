package com.hosseinzafari.github.app.karak.feature_auth.data.remote.repository

import com.google.firebase.auth.FirebaseUser
import com.hosseinzafari.github.app.karak.feature_auth.data.remote.datasource.FirebaseGoogleAuthDataSource
import com.hosseinzafari.github.app.karak.feature_auth.domain.model.UserModel
import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.UserAuthRepository
import com.hosseinzafari.github.framework.todoapp.feature_note.domain.utils.DomainMapper
import javax.inject.Inject

/*

@created in 12/12/2021 - 4:52 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class UserAuthRepositoryImpl @Inject constructor(
    val firebaseGoogleAuthDataSource: FirebaseGoogleAuthDataSource ,
    val mapper: DomainMapper<FirebaseUser , UserModel>
) : UserAuthRepository {

    override fun getUser(): UserModel {
        return mapper.mapFromEntity(firebaseGoogleAuthDataSource.firebaseAuth.currentUser)!!
    }

    override fun signOut() {
    }

    override fun userIsSigned() = firebaseGoogleAuthDataSource.firebaseAuth.currentUser != null
}