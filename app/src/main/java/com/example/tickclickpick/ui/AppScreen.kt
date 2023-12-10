package com.example.tickclickpick.ui

sealed class AppScreen(val screenName: String) {
    data object SplashScreen: AppScreen("splash_screen")
    data object HomeScreen: AppScreen("home_screen")
}