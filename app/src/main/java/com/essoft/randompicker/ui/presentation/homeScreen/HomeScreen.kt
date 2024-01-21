package com.essoft.randompicker.ui.presentation.homeScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.essoft.randompicker.R
import com.essoft.randompicker.constants.ButtonType
import com.essoft.randompicker.constants.ColorConstants
import com.essoft.randompicker.repo.FoodRepositoryMock
import com.essoft.randompicker.ui.common.BackgroundImage
import com.essoft.randompicker.ui.common.CustomDialog
import com.essoft.randompicker.ui.common.CustomTextField
import com.essoft.randompicker.ui.common.FoodItemList
import com.essoft.randompicker.ui.common.GradientButton
import com.essoft.randompicker.ui.common.TitleBar
import com.essoft.randompicker.ui.theme.AppTheme
import com.essoft.randompicker.viewmodel.HomeViewModel
import com.essoft.randompicker.viewmodel.HomeViewModelMock
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val openAlertDialog = remember { mutableStateOf(viewModel.getDialogState()) }

    //Prevent onBackPressed to splash screen
    BackHandler { }

    LaunchedEffect(Unit) {
        //viewModel.createDemoFood()
        viewModel.retrieveAllFood()
    }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(ColorConstants.BACKGROUND)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                BackgroundImage()

                Column {
                    Spacer(modifier = Modifier.padding(top = 60.dp))

                    TitleBar()

                    //Spacer(modifier = Modifier.padding(top = 18.dp))

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
                    .align(Alignment.BottomCenter)
                ) {
                    CustomTextField(onValueChange = { viewModel.setFoodName(it) })

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()) {

                        GradientButton(
                            ButtonType.MAIN,
                            onButtonClick = { viewModel.pickFood() },
                            buttonTextId = R.string.btn_pick,
                            modifier = Modifier
                                .width(233.dp)
                                .weight(0.7f)
                                .padding(start = 24.dp, end = 24.dp, bottom = 32.dp))

                        GradientButton(
                            ButtonType.SUB,
                            onButtonClick = { viewModel.createFood() },
                            buttonTextId = R.string.btn_add,
                            modifier = Modifier
                                .width(82.dp)
                                .weight(0.3f)
                                .padding(end = 24.dp, bottom = 32.dp))
                    }
                }
            }

            when(openAlertDialog.value.value.showDialog) {
                true -> {
                    CustomDialog(onDismissRequest = { viewModel.resetDialogState() }, dialogText = viewModel.getDialogState().value.message)
                }
                else -> {

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
