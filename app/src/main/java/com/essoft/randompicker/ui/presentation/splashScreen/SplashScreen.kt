package com.essoft.randompicker.ui.presentation.splashScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.essoft.randompicker.R
import com.essoft.randompicker.constants.ButtonType
import com.essoft.randompicker.constants.ColorConstants
import com.essoft.randompicker.ui.common.GradientButton
import com.essoft.randompicker.ui.common.SubtitleText
import com.essoft.randompicker.ui.common.TitleText
import com.essoft.randompicker.ui.theme.AppTheme

@Composable
fun SplashScreen(onButtonClick: () -> Unit) {
    //val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    //val progress by animateLottieCompositionAsState(composition = composition)
    // Add a delay using LaunchedEffect and Coroutine
    LaunchedEffect(Unit) {
        //delay(GeneralConstants.SPLASH_SCREEN_DURATION)
        //onFinishLoading()
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color(ColorConstants.BACKGROUND)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 56.dp))

            SplashImage()

            TitleText()

            Spacer(modifier = Modifier.padding(top = 20.dp))

            SubtitleText()

            Spacer(modifier = Modifier.padding(top = 42.dp))

            GradientButton(ButtonType.MAIN, onButtonClick, R.string.btn_next, Modifier.width(157.dp))
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen()
{
    AppTheme { SplashScreen(onButtonClick = { }) }
}