package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.tickclickpick.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            //titleContentColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),

        title = {
            Text(stringResource(R.string.home))
        },

        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Rounded.AccountCircle,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}