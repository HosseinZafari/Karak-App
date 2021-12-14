package com.hosseinzafari.github.app.karak.feature_auth.domain.model

import android.net.Uri
import java.net.URL

/*

@created in 11/12/2021 - 9:59 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

data class UserModel(
    val id: String ,
    val name: String? ,
    val email: String? ,
    val photoUrl: Uri? = null,
    val phoneNumber: String? = null,
)