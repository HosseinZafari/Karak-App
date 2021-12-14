package com.hosseinzafari.github.app.karak.feature_auth.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.hosseinzafari.github.app.karak.core.UComponentActivity
import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.GoogleAuthRepository
import com.hosseinzafari.github.app.karak.feature_auth.domain.use_cases.GetUserUseCase
import com.hosseinzafari.github.app.karak.feature_auth.domain.use_cases.GoogleGetIntentUserCase
import com.hosseinzafari.github.app.karak.feature_auth.domain.use_cases.GoogleSignInUseCase
import com.hosseinzafari.github.app.karak.feature_auth.domain.utils.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
    @created in 12/12/2021 - 12:39 PM
    @project Karak
    @author Hossein Zafari
    @email  hosseinzafari2000@gmail.com
*/

@HiltViewModel
class AuthViewModel @Inject constructor(
    val googleAuthRepository: GoogleAuthRepository,
    val googleGetIntentUserCase: GoogleGetIntentUserCase,
    val googleSignInUseCase: GoogleSignInUseCase,
    val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _signInState: MutableState<AuthState> = mutableStateOf(AuthState.NoRequested)
    val signInState: State<AuthState> = _signInState

    fun signInWithGoogle(activity: UComponentActivity) {
        _signInState.value = AuthState.Loading
        activity.launchActivityResult(
            googleGetIntentUserCase(),
            error = {
                _signInState.value = AuthState.Failed("متاسفانه ورود از طریق گوگل در دستگاه شما امکان پذیر نیست")
            },
            success = { resultIntent ->
                googleSignInUseCase(resultIntent ,
                    onResultListener = { task ->
                       checkAuthState(task)
                    },
                    onError = {
                        _signInState.value = AuthState.Failed("مشکلی در ورود شما وجود دارد لطفا بعدا مجددا امتحان کنید")
                    }
                )
            }
        )

    }

    private fun checkAuthState(task: Task<AuthResult>) {
        when  {
            task.isSuccessful -> {
                _signInState.value = AuthState.Success(getUserUseCase())
            }

            task.isCanceled -> {
                _signInState.value = AuthState.Failed("ورود با گوگل مسدود شد")
            }

            task.isComplete -> {
                _signInState.value = AuthState.Loading
            }
        }
    }

    fun signInWithEmailAndPassword() {

    }

    fun onEvent() {

    }


}