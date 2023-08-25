package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tickclickpick.ui.theme.AppTheme

@Composable
fun DashBoard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(bottomStart = 36.dp, bottomEnd = 36.dp)
            )
    ) {
    // Your content inside the rounded bottom rectangle
    }
}

@Preview
@Composable
fun PreviewDashBoard() {
    AppTheme {
        DashBoard()
    }
}