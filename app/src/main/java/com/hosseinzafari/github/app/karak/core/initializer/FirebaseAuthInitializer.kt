package com.hosseinzafari.github.app.karak.core.initializer

import android.content.Context
import androidx.startup.Initializer
import com.google.firebase.auth.FirebaseAuth

/*

@created in 11/12/2021 - 2:54 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

class FirebaseAuthInitializer : Initializer<FirebaseAuth> {

    override fun create(context: Context): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {

       return mutableListOf()
    }
}