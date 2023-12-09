package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.ColorConstants

@Composable
fun TitleBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = stringResource(id = R.string.title_pick_food),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 40.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 32.dp))
        Icon(
            Icons.Filled.Restaurant,
            contentDescription = "",
            tint = Color(ColorConstants.Button.GRADIENT_START),
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .padding(end = 40.dp)
                .size(45.dp))
    }
}

@Preview
@Composable
fun PreviewTitleBar() {
    TitleBar()
}