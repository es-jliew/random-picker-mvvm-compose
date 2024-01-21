package com.essoft.randompicker.ui.presentation.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.essoft.randompicker.R

@Composable
fun SplashImage() {
    val painter = painterResource(id = R.drawable.img_splash)
    Image(painter, "",
        modifier = Modifier.padding(end = 18.dp),)
}
