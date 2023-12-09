package com.example.tickclickpick.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.constants.ColorConstants

@Composable
fun GradientButton(onButtonClick: () -> Unit = {}, buttonText: String, modifier: Modifier) {
    val gradientColors = listOf(
        Color(ColorConstants.Button.GRADIENT_START), // Start color
        Color(ColorConstants.Button.GRADIENT_END) //End color
    )
    Button(
        onClick = { onButtonClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .height(57.dp)
            .width(157.dp)
            //.clip(shape)
            .background(
                brush = Brush.horizontalGradient(gradientColors),
                shape = RoundedCornerShape(15.dp)
            ),) {
        Text(text = buttonText,
            fontSize = 16.sp)
    }
}

@Preview
@Composable
fun PreviewGradientButton() {
    GradientButton({},"Sample", modifier = Modifier)
}
