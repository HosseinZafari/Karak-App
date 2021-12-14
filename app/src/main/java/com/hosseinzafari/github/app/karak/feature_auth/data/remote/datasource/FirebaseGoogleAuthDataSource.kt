package com.hosseinzafari.github.app.karak.feature_auth.data.remote.datasource

import android.content.Intent
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.hosseinzafari.github.app.karak.feature_auth.domain.model.UserModel
import com.hosseinzafari.github.app.karak.feature_auth.domain.utils.AuthState
import com.hosseinzafari.github.framework.todoapp.feature_note.domain.utils.DomainMapper
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/*

@created in 11/12/2021 - 10:06 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class FirebaseGoogleAuthDataSource @Inject constructor(
    val firebaseAuth: FirebaseAuth,
    val googleSignInClient: GoogleSignInClient,
    val userModelMapper: DomainMapper<FirebaseUser, UserModel>,
) {

    fun startSignIn(
        resultIntent: Intent,
        onResultListener: (Task<AuthResult>) -> Unit,
        onError: () -> Unit
    ) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(resultIntent) // get callback intent
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken , null)
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener(onResultListener)
        } catch (e: ApiException) {
            onError()
            Log.d("TAG", "error :" + e)
        }
    }

    fun getRequestIntentGoogleSignIn (): Intent {
        return googleSignInClient.signInIntent
    }




}