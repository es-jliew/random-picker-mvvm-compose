package com.essoft.randompicker.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.essoft.randompicker.ui.presentation.homeScreen.HomeScreen
import com.essoft.randompicker.ui.presentation.splashScreen.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = AppScreen.SplashScreen.screenName
    ) {
        composable(route = AppScreen.SplashScreen.screenName) {
            SplashScreen(
                onButtonClick = { navController.navigate(AppScreen.HomeScreen.screenName) }
            )
        }
        composable(route = AppScreen.HomeScreen.screenName) {
            HomeScreen(
                //onTabClicked = { navController.navigate(AppScreen.FoodListScreen.screenName) }
            )
        }
    }
}