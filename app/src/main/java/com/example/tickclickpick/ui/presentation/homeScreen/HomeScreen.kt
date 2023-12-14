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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.R
import com.example.tickclickpick.constants.ButtonType
import com.example.tickclickpick.constants.ColorConstants
import com.example.tickclickpick.repo.FoodRepositoryMock
import com.example.tickclickpick.ui.common.BackgroundImage
import com.example.tickclickpick.ui.common.FoodItemList
import com.example.tickclickpick.ui.common.GradientButton
import com.example.tickclickpick.ui.common.TitleBar
import com.example.tickclickpick.ui.theme.AppTheme
import com.example.tickclickpick.viewmodel.HomeViewModel
import com.example.tickclickpick.viewmodel.HomeViewModelMock
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    //var selectedTab by remember { mutableStateOf(BottomNavItem.Home) }
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

                    Box(
                        modifier = Modifier.padding(bottom = 100.dp)
                    ) {
                        FoodItemList(viewModel = viewModel)
                    }
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)) {
                    OutlinedTextField(
                        value = "Enter Food Name",
                        onValueChange = {},
                        leadingIcon = {
                            Icon(imageVector = Icons.Rounded.EditNote, contentDescription = "",
                                //tint = Color(ColorConstants.Button.GRADIENT_START),
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .graphicsLayer(alpha = 0.99f)
                                    .drawWithCache {
                                        val brush = Brush.horizontalGradient(
                                            listOf(
                                                Color(ColorConstants.Button.GRADIENT_START),
                                                Color(ColorConstants.Button.GRADIENT_END)
                                            )
                                        )
                                        onDrawWithContent {
                                            drawContent()
                                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                                        }
                                    }
                                )},
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .padding(start = 24.dp, end = 24.dp, bottom = 18.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            unfocusedTextColor = Color.White.copy(alpha = 0.4f),
                            focusedContainerColor = Color.White.copy(0.1f),
                            unfocusedContainerColor = Color.White.copy(0.1f),
                            //disabledContainerColor = containerColor,
                        )
                    )
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

@Composable
fun BottomNavItems(
    onItemSelected: (BottomNavItem) -> Unit,
    selectedTab: BottomNavItem
) {
    val navItems = BottomNavItem.entries.toTypedArray()

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
        val homeViewModelMock = HomeViewModelMock(mockFoodRepository)
        HomeScreen(homeViewModelMock)
    }
}
