package com.hosseinzafari.github.app.karak.feature_auth.domain.use_cases

import android.content.Intent
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.GoogleAuthRepository
import javax.inject.Inject

/*

@created in 12/12/2021 - 4:23 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class GoogleGetIntentUserCase @Inject constructor(
    val repository: GoogleAuthRepository
) {

    operator fun invoke()  : Intent {
        return repository.getRequestIntentGoogleSignIn()
    }

}