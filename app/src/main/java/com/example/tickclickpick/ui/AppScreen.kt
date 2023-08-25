package com.example.tickclickpick.ui

sealed class AppScreen(val screenName: String) {
    object SplashScreen: AppScreen("splash_screen")
    object HomeScreen: AppScreen("home_screen")
    object FoodListScreen: AppScreen("food_list_screen")
}