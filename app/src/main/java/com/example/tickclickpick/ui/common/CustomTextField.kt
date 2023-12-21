package com.example.tickclickpick.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.tickclickpick.constants.ColorConstants

@Composable
fun CustomTextField() {
    OutlinedTextField(
        value = "Enter Food Name",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Rounded.EditNote, contentDescription = "",
                //tint = Color(ColorConstants.Button.GRADIENT_START),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        val brush = Brush.horizontalGradient(
                            listOf(
                                Color(ColorConstants.Button.GRADIENT_START),
                                Color(ColorConstants.Button.GRADIENT_END)
                            )
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                        }
                    }
            )
        },
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 18.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color.White.copy(alpha = 0.4f),
            focusedContainerColor = Color.White.copy(0.1f),
            unfocusedContainerColor = Color.White.copy(0.1f),
            //disabledContainerColor = containerColor,
        )
    )
}