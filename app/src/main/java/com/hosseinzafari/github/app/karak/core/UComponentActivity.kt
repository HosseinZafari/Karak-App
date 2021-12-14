package com.hosseinzafari.github.app.karak.core

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

/*

@created in 11/12/2021 - 10:09 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

open class UComponentActivity: ComponentActivity() {

    private var launchActivityForResultError: () -> Unit = {}
    private var launchActivityForResultSuccess: (Intent) -> Unit = {}

    private lateinit var uLauncherActivityResult: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(KarakApplication.LOG_TAG , "UComponentActivity onCreate() called")


        setupConfig()
    }

    private fun setupConfig() {

        configRegisterForActivityResult()
    }

    fun launchActivityResult(
        requestIntent: Intent,
        error: () -> Unit = {},
        success: (Intent) -> Unit = {}
    ) {
        launchActivityForResultError = error
        launchActivityForResultSuccess = success
        uLauncherActivityResult.launch(requestIntent)
    }

    private fun configRegisterForActivityResult() {
        uLauncherActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == Activity.RESULT_OK) {
                launchActivityForResultSuccess(result.data!!)
            } else {
                launchActivityForResultError()
            }
        }
    }


}