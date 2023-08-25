package com.example.tickclickpick.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tickclickpick.ui.presentation.foodListScreen.FoodListScreen
import com.example.tickclickpick.ui.presentation.homeScreen.HomeScreen
import com.example.tickclickpick.ui.presentation.splashScreen.SplashScreen

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
                onFinishLoading = { navController.navigate(AppScreen.HomeScreen.screenName) }
            )
        }
        composable(route = AppScreen.HomeScreen.screenName) {
            HomeScreen()
        }
        composable(route = AppScreen.FoodListScreen.screenName) {
            FoodListScreen()
        }
    }
}