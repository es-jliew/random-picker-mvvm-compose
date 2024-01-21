package com.essoft.randompicker.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essoft.randompicker.R
import com.essoft.randompicker.constants.ButtonType
import com.essoft.randompicker.constants.ColorConstants

@Composable
fun GradientButton(buttonType: ButtonType, onButtonClick: () -> Unit = {}, buttonTextId: Int, modifier: Modifier) {
    val gradientColors = if (buttonType == ButtonType.MAIN) {
        ColorConstants.Button.GRADIENT_MAIN
    } else {
        ColorConstants.Button.GRADIENT_SUB
    }

    Button(
        onClick = { onButtonClick() },
        modifier = modifier
            .height(57.dp)
            .background(
                brush = Brush.horizontalGradient(gradientColors),
                shape = RoundedCornerShape(15.dp))
            .border(
                width = when (buttonType) {
                    ButtonType.SUB -> 1.dp
                    else -> 0.dp
                },
                color = when (buttonType) {
                    ButtonType.SUB -> Color(ColorConstants.Button.BORDER).copy(0.1f)
                    else -> Color.Transparent
                },
                shape = RoundedCornerShape(15.dp)
            ),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        ) {
        Text(
            text = stringResource(id = buttonTextId),
            fontSize = 16.sp)
    }
}

@Preview
@Composable
fun PreviewGradientButton() {
    GradientButton(ButtonType.MAIN, {}, R.string.btn_pick, modifier = Modifier)
}
