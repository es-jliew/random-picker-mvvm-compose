package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.tickclickpick.R
import com.example.tickclickpick.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var selectedTab by remember { mutableStateOf(BottomNavItem.Home) }
    //Prevent onBackPressed to splash screen
    BackHandler { }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    //containerColor = Color.Black,
                    //titleContentColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(stringResource(R.string.app_name))
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Filled.Home,
                            //tint = Color.White,
                            contentDescription = "Localized description",
                            tint = Color.White)
                    }
                }
            )
            TopAppBar()
        },
        bottomBar = {
            BottomAppBar(
                //containerColor = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier,
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Filled.Home,
                        //tint = Color.White,
                        contentDescription = "Localized description")
                }
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            Icons.Filled.List,
                            //tint = Color.White,
                            contentDescription = "Localized description",
                        )
                    }},
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        //containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
                )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        Surface(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.primary
            //color = Color.Black
        ) {
            Column() {
                Box(
                    Modifier.fillMaxWidth()
                ) {
                    //DashBoard(
                    SearchBar(
                        modifier = Modifier
                            .align(Alignment.TopCenter),
                        query = "String",
                        onQueryChange = {},
                        onSearch = {},
                        active = false,
                        onActiveChange = {},
                        shape = SearchBarDefaults.inputFieldShape,
                        placeholder = { Text("Hinted search text") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
                    ) {}
                }
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.title_your_meal_list),
                    color = Color.White, style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium,
                )
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
        HomeScreen()
    }
}