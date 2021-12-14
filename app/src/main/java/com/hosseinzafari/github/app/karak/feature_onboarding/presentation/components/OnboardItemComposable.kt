package com.hosseinzafari.github.app.karak.feature_onboarding.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hosseinzafari.github.app.karak.R
import com.hosseinzafari.github.app.karak.core.presentation.theme.BlueLight

/*

@created in 13/12/2021 - 3:18 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/
@Composable
fun OnboardItemComposable(
    @DrawableRes drawableResId: Int,
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = drawableResId),
            contentDescription = "onboard image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = subTitle,
                style = MaterialTheme.typography.body2,
                color = Color.DarkGray,
                fontSize = 16.sp
            )

        }
    }

}


@Preview(showBackground = true)
@Composable
fun TestOnboardItemComposable() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        OnboardItemComposable(
            drawableResId = R.drawable.onboard1,
            title = "به کارک خوش آمدید",
            subTitle = "وقتی زمان انجام کار پیش میاد مطلع شو",
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color.White)
        )

    }
}
