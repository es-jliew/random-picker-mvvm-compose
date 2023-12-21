package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.ButtonType
import com.example.tickclickpick.constants.ColorConstants
import com.example.tickclickpick.repo.FoodRepositoryMock
import com.example.tickclickpick.ui.common.BackgroundImage
import com.example.tickclickpick.ui.common.CustomTextField
import com.example.tickclickpick.ui.common.FoodItemList
import com.example.tickclickpick.ui.common.GradientButton
import com.example.tickclickpick.ui.common.TitleBar
import com.example.tickclickpick.ui.theme.AppTheme
import com.example.tickclickpick.viewmodel.HomeViewModel
import com.example.tickclickpick.viewmodel.HomeViewModelMock
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
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
                BackgroundImage()

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

                    FoodItemList(viewModel = viewModel)
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)) {
                    CustomTextField()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()) {

                        GradientButton(
                            ButtonType.MAIN,
                            {},
                            buttonTextId = R.string.btn_pick,
                            modifier = Modifier
                                .width(233.dp)
                                .weight(0.7f)
                                .padding(start = 24.dp, end = 24.dp, bottom = 32.dp))

                        GradientButton(
                            ButtonType.SUB,
                            {},
                            buttonTextId = R.string.btn_add,
                            modifier = Modifier
                                .width(82.dp)
                                .weight(0.3f)
                                .padding(end = 24.dp, bottom = 32.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    AppTheme {
        val mockFoodRepository = FoodRepositoryMock()
        val homeViewModelMock = HomeViewModelMock(mockFoodRepository)
        HomeScreen(homeViewModelMock)
    }
}
