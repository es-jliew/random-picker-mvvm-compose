package com.example.tickclickpick.ui.presentation.splashScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.GeneralConstants
import com.example.tickclickpick.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinishLoading: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    val progress by animateLottieCompositionAsState(composition = composition)
    // Add a delay using LaunchedEffect and Coroutine
    LaunchedEffect(Unit) {
        delay(GeneralConstants.SPLASH_SCREEN_DURATION)
        onFinishLoading()
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        Box (
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Tick. Click. Pick")
                Spacer(modifier = Modifier.height(16.dp))
                LottieAnimation(composition = composition, progress = { progress })
            }
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen()
{
    AppTheme { SplashScreen(onFinishLoading = { }) }
}