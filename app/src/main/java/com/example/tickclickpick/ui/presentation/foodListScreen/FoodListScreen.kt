package com.example.tickclickpick.ui.presentation.foodListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tickclickpick.R
import com.example.tickclickpick.ui.presentation.homeScreen.FoodItem
import com.example.tickclickpick.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun FoodListScreen(
    viewModel: FoodListViewModel = koinViewModel()
) {
    var foodModelList = viewModel.foodModelList

    LaunchedEffect(Unit) {
        //viewModel.addRecipe()
        //viewModel.createDemoFood()
        viewModel.retrieveAllFood()
    }

    Scaffold(
        content = { padding -> Surface(modifier = Modifier.padding(padding)) {
            LazyColumn(modifier = Modifier) {
                if (foodModelList.isNotEmpty()) {
                    items(foodModelList) { foodModel -> FoodItem(foodModel = foodModel) {
                        foodModelList = foodModelList.toMutableList().also { itemList -> itemList.remove(foodModel) }
                    } }
                } else {
                    item{ ShowNoFood() }
                }
            }
        }}
    )
}

@Preview
@Composable
fun PreviewFoodListScreen() {
    AppTheme {
        FoodListScreen()
    }
}

@Composable
fun ShowNoFood() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp, 120.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_app_launcher),
            contentDescription = "empty",
            modifier = Modifier
                .alpha(0.5f)
                .fillMaxWidth(),
            alignment = Alignment.Center
        )
        Text(text = "Your recipes will show here",
            modifier = Modifier.fillMaxWidth(),
            //textAlign = TextAlign.Center
        )
    }
}