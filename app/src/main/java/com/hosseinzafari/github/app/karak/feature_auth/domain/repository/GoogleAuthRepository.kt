package com.hosseinzafari.github.app.karak.feature_auth.domain.repository

import android.content.Intent
import androidx.compose.runtime.State
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.hosseinzafari.github.app.karak.feature_auth.domain.utils.AuthState


/*

@created in 11/12/2021 - 9:52 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

interface GoogleAuthRepository {
    fun signInGoogle(resultIntent: Intent , onResultListener: (Task<AuthResult>) -> Unit ,   onError: () -> Unit)

    fun getRequestIntentGoogleSignIn() : Intent
}