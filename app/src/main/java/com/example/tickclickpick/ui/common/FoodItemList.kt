package com.example.tickclickpick.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tickclickpick.R
import com.example.tickclickpick.viewmodel.IHomeViewModel

@Composable
fun FoodItemList(viewModel: IHomeViewModel) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier) {
        if (viewModel.getFoodList().isNotEmpty()) {
            items(viewModel.getFoodList()) { foodModel ->
                FoodItem(
                    foodModel = foodModel,
                    onRemoveClick = {},
                    onCheckboxClicked = { updatedFoodModel ->
                        viewModel.upDateFoodModel(updatedFoodModel)
                })
            }
        } else {
            item{ ShowNoFood() }
        }
    }
}

@Preview
@Composable
fun ShowNoFood() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.img_home),
            contentDescription = "empty",
            modifier = Modifier
                .alpha(0.5f)
                .fillMaxWidth(),
            alignment = Alignment.Center
        )
    }
}