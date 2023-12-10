package com.example.tickclickpick.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.R

@Composable
fun TitleText() {
    Text(
        stringResource(id = R.string.title_cannot_decide_meal),
        color = Color.White,
        fontSize = 22.sp,
        textAlign = TextAlign.Center,
        lineHeight = 28.sp)
}
