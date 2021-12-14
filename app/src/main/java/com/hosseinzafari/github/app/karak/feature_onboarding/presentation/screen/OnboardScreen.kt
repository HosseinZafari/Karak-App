package com.hosseinzafari.github.app.karak.feature_onboarding.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.hosseinzafari.github.app.karak.R
import com.hosseinzafari.github.app.karak.feature_onboarding.presentation.components.OnboardItemComposable

/*

@created in 13/12/2021 - 4:33 PM
@project Karak
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

@ExperimentalPagerApi
@Composable
fun OnboardScreen(
    onStartButtonClick : () -> Unit = {} ,
    onSignInButtonClick: () -> Unit = {}
) {
    val pageState = rememberPagerState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        HorizontalPager(
            count = 3,
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp),
            pageState,
            contentPadding = PaddingValues(16.dp)
        ) {
            when (currentPage) {
                0 -> {
                    OnboardItemComposable(
                        drawableResId = R.drawable.onboard1,
                        title = "به کارک خوش آمدید",
                        subTitle = "چه کاری قراره فردا انجام بشه ؟" ,
                        modifier = Modifier.fillMaxHeight()
                    )
                }

                1 -> {
                    OnboardItemComposable(
                        drawableResId = R.drawable.onboard2,
                        title = "من یادت می ندازم",
                        subTitle = "وقتی زمان انجام کار پیش میاد مطلع شو" ,
                        modifier = Modifier.fillMaxHeight()
                    )

                }

                2 -> {
                    OnboardItemComposable(
                        drawableResId = R.drawable.onboard3,
                        title = "زمانتان را مدیریت کنید",
                        subTitle = "هیچ چیزی را از دست ندهید" ,
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            }
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
            pagerState = pageState,
            indicatorShape = CircleShape,
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly ,
            verticalAlignment = Alignment.CenterVertically ,
            modifier = Modifier
                .padding(horizontal = 16.dp , vertical = 24.dp)
                .clickable(onClick = onSignInButtonClick)
        ){
            Text(
                text = "ورود به حساب کاربری",
                style = MaterialTheme.typography.h2,
                color = Color.DarkGray,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "ورود به حساب",
                tint = MaterialTheme.colors.primary
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(onClick = onStartButtonClick ,
                modifier = Modifier
                    .width(250.dp)
                    .clip(RoundedCornerShape(18.dp , 0.dp , 0.dp , 18.dp))
            ) {
                Text(
                    text = "شروع کنید",
                    modifier = Modifier.padding(horizontal = 38.dp , vertical = 16.dp),
                    fontSize = 24.sp
                )


                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "شروع کنید",
                    tint = Color.White ,
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}


@ExperimentalPagerApi
@Composable
@Preview(showBackground = true)
fun TestOnboardScreen() {
    OnboardScreen()
}