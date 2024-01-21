package com.essoft.randompicker.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.essoft.randompicker.R
import com.essoft.randompicker.viewmodel.IHomeViewModel

@Composable
fun FoodItemList(viewModel: IHomeViewModel) {
    val foodList by remember { viewModel.getFoodList() }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(bottom = 180.dp)) {
        if (foodList.isNotEmpty()) {
            items(foodList) {it ->
                FoodItem(
                    foodModel = it,
                    onRemoveClick = { viewModel.deleteFood(it) },
                    onCheckboxClicked = { viewModel.updateFoodModel(it) })
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
                .fillMaxWidth()
                .alpha(0.4f),
            alignment = Alignment.Center
        )
    }
}