package com.hosseinzafari.github.app.karak.core

import android.app.Activity
import android.app.Application
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.HiltAndroidApp

/*

@created in 11/12/2021 - 12:59 AM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

@HiltAndroidApp
class KarakApplication : Application() {

    companion object {
        const val LOG_TAG = "LOG_KARAK"
        const val SIMPLE_MSG = "########## THIS IS SIMPLE MESSAGE FOR LOGCAT ##########"
    }

    override fun onCreate() {
        super.onCreate()


    }



}