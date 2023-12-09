package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.ColorConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar() {
    TopAppBar(
        modifier = Modifier.wrapContentHeight(Alignment.CenterVertically, true),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(ColorConstants.BACKGROUND),
            //titleContentColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),

        title = {
            Text(
                stringResource(R.string.title_pick_food),
                fontSize = 32.sp,
                fontWeight = FontWeight.W400,
                //lineHeight = 40.sp
                )
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