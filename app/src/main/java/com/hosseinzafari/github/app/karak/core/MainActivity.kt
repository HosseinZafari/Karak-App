package com.hosseinzafari.github.app.karak.core

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hosseinzafari.github.app.karak.core.presentation.theme.KarakTheme
import com.hosseinzafari.github.app.karak.feature_auth.domain.utils.AuthState
import com.hosseinzafari.github.app.karak.feature_auth.presentation.AuthViewModel
import com.hosseinzafari.github.app.karak.feature_onboarding.presentation.screen.OnboardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : UComponentActivity() {

    companion object {
        const val SPLASH_SCREEN_ANIM_DURATION = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val isShowedSplashScreen = savedInstanceState != null
        if (isShowedSplashScreen) {
            setContent {
                KarakTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        TestFireBase()

                    }
                }
            }
        } else {
            val splashScreen = installSplashScreen()
            splashScreen.setOnExitAnimationListener { provider ->
                provider.iconView.animate()
                    .setDuration(SPLASH_SCREEN_ANIM_DURATION)
                    .alpha(0f)
                    .withEndAction {
                        provider.remove()
                        setContent {
                            KarakTheme {
                                // A surface container using the 'background' color from the theme
                                Surface(color = MaterialTheme.colors.background) {
                                    TestFireBase()

                                }
                            }
                        }
                    }.start()
            }
        }

    }


    @Composable
    fun TestFireBase() {
        val viewModel: AuthViewModel = hiltViewModel()
        val signState = viewModel.signInState

        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colors.isLight
        SideEffect {
            systemUiController.setSystemBarsColor(Color.Transparent, useDarkIcons)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = {
                viewModel.signInWithGoogle(this@MainActivity)
            }) {
                Text(text = "Google SignIn")
            }

            if (signState.value is AuthState.Success) {
                Text("Successfully " + (signState.value as AuthState.Success).userModel)
            } else if (signState.value is AuthState.Loading) {
                Text("Loading")
            } else if (signState.value is AuthState.Failed) {
                Text("Filed")
            } else if (signState.value is AuthState.NoRequested) {
                Text("Requested")
            }

        }
    }

    @ExperimentalPagerApi
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KarakTheme {
            OnboardScreen()
//            TestFireBase()
        }
    }
}