package com.example.tickclickpick.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.ColorConstants

@Composable
fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.img_background),
        contentDescription = "empty",
        modifier = Modifier
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                )
                onDrawWithContent {
                    drawContent()
                    drawRect(gradient,blendMode = BlendMode.Multiply)
                }
            }
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(listOf(Color.Transparent, Color(ColorConstants.BACKGROUND_TOP)))),
    )
}
