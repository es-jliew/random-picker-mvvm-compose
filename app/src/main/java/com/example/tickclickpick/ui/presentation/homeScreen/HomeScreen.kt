package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.ColorConstants
import com.example.tickclickpick.model.FoodModel
import com.example.tickclickpick.repo.IFoodRepository
import com.example.tickclickpick.ui.common.GradientButton
import com.example.tickclickpick.ui.presentation.foodListScreen.FoodListViewModel
import com.example.tickclickpick.ui.presentation.foodListScreen.ShowNoFood
import com.example.tickclickpick.ui.theme.AppTheme
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: FoodListViewModel = koinViewModel()) {
    var foodModelList = viewModel.foodModelList
    var selectedTab by remember { mutableStateOf(BottomNavItem.Home) }
    //Prevent onBackPressed to splash screen
    BackHandler { }

    LaunchedEffect(Unit) {
        //viewModel.createDemoFood()
        viewModel.retrieveAllFood()
    }

    Scaffold { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            color = Color(ColorConstants.BACKGROUND)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {
                    Spacer(modifier = Modifier.padding(top = 60.dp))

                    TitleBar()

                    Spacer(modifier = Modifier.padding(top = 18.dp))

                    HomeSearchBar()

                    Spacer(modifier = Modifier.padding(top = 20.dp))

                    Text(
                        modifier = Modifier.padding(start = 24.dp),
                        text = stringResource(id = R.string.title_your_meal_list),
                        color = Color.White,
                        fontWeight = FontWeight.W600,
                        lineHeight = 20.sp,
                        fontSize = 16.sp,
                    )

                    Spacer(modifier = Modifier.padding(top = 20.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        modifier = Modifier) {
                        if (foodModelList.isNotEmpty()) {
                            items(foodModelList) { foodModel -> FoodItem(foodModel = foodModel) {
                                foodModelList = foodModelList.toMutableList().also { itemList -> itemList.remove(foodModel) }
                            } }
                        } else {
                            item{ ShowNoFood() }
                        }
                    }
                }

                GradientButton(
                    {},
                    stringResource(id = R.string.btn_pick),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, bottom = 32.dp))
            }
        }
    }
}

@Composable
fun BottomNavItems(
    onItemSelected: (BottomNavItem) -> Unit,
    selectedTab: BottomNavItem
) {
    val navItems = BottomNavItem.values()

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        navItems.forEach { item ->
            BottomNavItem(
                icon = item.icon,
                text = item.title,
                isSelected = item == selectedTab,
                onItemClick = { onItemSelected(item) }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    text: String,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    val shape = CircleShape // Use CircleShape for round icons, or RoundedCornerShape(50) for rounded rectangle icons

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight()
            .clickable(onClick = onItemClick)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.White,
            modifier = Modifier
                .size(36.dp)
                .padding(8.dp)
                .clip(shape)
                .background(if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent)
        )
        Text(
            text = text,
            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White,
            textAlign = TextAlign.Center
        )
    }
}

enum class BottomNavItem(val icon: ImageVector, val title: String) {
    Home(Icons.Default.Home, "Home"),
    Search(Icons.Default.List, "List")
}


@Preview
@Composable
fun PreviewHomeScreen() {
    AppTheme {
        val mockFoodRepository = FoodRepositoryMock()
        val mockViewModel = FoodListViewModelMock(foodRepository = mockFoodRepository)
        HomeScreen(viewModel = mockViewModel)
    }
}
 class FoodRepositoryMock : IFoodRepository {
     // Implement mock behavior as needed for preview
     override suspend fun retrieveAllFood(): Flow<List<FoodModel>> {
         TODO("Not yet implemented")
     }

     override suspend fun createFood(foodModel: FoodModel) {
         TODO("Not yet implemented")
     }

     override suspend fun deleteFood(foodModel: FoodModel) {
         TODO("Not yet implemented")
     }

     override suspend fun updateFood(foodModel: FoodModel) {
         TODO("Not yet implemented")
     }

     override suspend fun createDemoFood() {
         TODO("Not yet implemented")
     }
 }
class FoodListViewModelMock(foodRepository: IFoodRepository) : FoodListViewModel(foodRepository) {
    // Implement mock behavior as needed for preview
}