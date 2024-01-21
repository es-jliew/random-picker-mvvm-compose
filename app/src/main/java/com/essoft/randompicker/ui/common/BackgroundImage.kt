package com.essoft.randompicker.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.essoft.randompicker.constants.ColorConstants
import com.essoft.randompicker.R


@Preview
@Composable
fun BackgroundImage() {
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.img_background),
        contentDescription = "empty",
        modifier = Modifier
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(ColorConstants.BACKGROUND)),
                    startY = size.height/(2.5f),
                    endY = size.height/2f)

                onDrawWithContent {
                    drawContent()
                    drawRect(gradient, blendMode = BlendMode.Darken)
                }
            }
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color(ColorConstants.BACKGROUND_TOP)
                    )
                )
            )
            //.offset(x= 0.dp, y= (-84).dp),
    )
}
