package com.hosseinzafari.github.app.karak.core.di

import android.content.Context
import androidx.startup.AppInitializer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.hosseinzafari.github.app.karak.core.initializer.FirebaseAuthInitializer
import com.hosseinzafari.github.app.karak.feature_auth.data.remote.datasource.FirebaseGoogleAuthDataSource
import com.hosseinzafari.github.app.karak.feature_auth.data.remote.repository.GoogleAuthRepositoryImpl
import com.hosseinzafari.github.app.karak.feature_auth.data.remote.repository.UserAuthRepositoryImpl
import com.hosseinzafari.github.app.karak.feature_auth.domain.model.UserModel
import com.hosseinzafari.github.app.karak.feature_auth.domain.model.UserModelMapper
import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.GoogleAuthRepository
import com.hosseinzafari.github.app.karak.feature_auth.domain.repository.UserAuthRepository
import com.hosseinzafari.github.framework.todoapp.feature_note.domain.utils.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*

@created in 11/12/2021 - 12:50 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    // Auth Firebase init

    @Singleton
    @Provides
    fun provideFirebaseAuth(
        @ApplicationContext
        context: Context
    ): FirebaseAuth =
        AppInitializer.getInstance(context).initializeComponent(FirebaseAuthInitializer::class.java)

    @Singleton
    @Provides
    fun provideGoogleAuthRepository(firebaseGoogleAuthDataSource: FirebaseGoogleAuthDataSource): GoogleAuthRepository {
        return GoogleAuthRepositoryImpl(firebaseGoogleAuthDataSource)
    }

    @Singleton
    @Provides
    fun provideUserAuthRepository(
        firebaseGoogleAuthDataSource: FirebaseGoogleAuthDataSource,
        mapper: DomainMapper<FirebaseUser, UserModel>
    ): UserAuthRepository {
        return UserAuthRepositoryImpl(firebaseGoogleAuthDataSource, mapper)
    }

    @Singleton
    @Provides
    fun provideFirebaseMapper(): DomainMapper<FirebaseUser, UserModel> {
        return UserModelMapper()
    }

    // For Google Sign in
    @Singleton
    @Provides
    fun providesGoogleSignInOptions(
    ): GoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("604778983726-pll6sojmqs4oa8t3aloeqhcpvv09td8n.apps.googleusercontent.com")
        .requestEmail()
        .build()

    @Singleton
    @Provides
    fun providesGoogleSignInClient(
        @ApplicationContext
        context: Context,
        googleSignInOptions: GoogleSignInOptions
    ): GoogleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions)

}