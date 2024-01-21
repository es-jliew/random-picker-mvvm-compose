package com.essoft.randompicker.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.essoft.randompicker.R

@Composable
fun SubtitleText() {
    Text(
        stringResource(id = R.string.desc_help_decide_meal),
        color = Color.White,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        lineHeight = 21.sp)
}