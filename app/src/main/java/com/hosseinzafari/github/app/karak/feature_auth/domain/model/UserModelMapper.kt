package com.hosseinzafari.github.app.karak.feature_auth.domain.model

import com.google.firebase.auth.FirebaseUser
import com.hosseinzafari.github.framework.todoapp.feature_note.domain.utils.DomainMapper

/*

@created in 11/12/2021 - 11:01 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class UserModelMapper : DomainMapper<FirebaseUser , UserModel> {

    override fun mapFromEntity(entity: FirebaseUser?): UserModel? {
        entity ?: return null
        return UserModel(
            id = entity.uid,
            name = entity.displayName,
            email = entity.email,
            photoUrl = entity.photoUrl,
            phoneNumber = entity.phoneNumber
        )
    }

    override fun mapFromModel(model: UserModel?): FirebaseUser? {
        return null
    }
}