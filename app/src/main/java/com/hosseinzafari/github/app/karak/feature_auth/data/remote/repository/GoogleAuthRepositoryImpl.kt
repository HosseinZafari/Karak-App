package com.hosseinzafari.github.app.karak.feature_auth.data.remote.repository

import android.content.Intent
import androidx.compose.runtime.State
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.hosseinzafari.github.app.karak.feature_auth.data.remote.datasource.FirebaseGoogleAuthDataSource
import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.GoogleAuthRepository
import com.hosseinzafari.github.app.karak.feature_auth.domain.utils.AuthState
import javax.inject.Inject

/*

@created in 11/12/2021 - 11:14 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class GoogleAuthRepositoryImpl @Inject constructor(
    var firebaseGoogleAuthDataSource: FirebaseGoogleAuthDataSource
) : GoogleAuthRepository{

    override fun signInGoogle(resultIntent: Intent , onResultListener: (Task<AuthResult>) -> Unit ,  onError: () -> Unit) {
        return firebaseGoogleAuthDataSource.startSignIn(resultIntent , onResultListener , onError)
    }

    override fun getRequestIntentGoogleSignIn(): Intent {
        return firebaseGoogleAuthDataSource.getRequestIntentGoogleSignIn()
    }

}