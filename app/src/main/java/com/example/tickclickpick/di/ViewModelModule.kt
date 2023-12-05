package com.example.tickclickpick.di

import com.example.tickclickpick.ui.presentation.foodListScreen.FoodListViewModel
import com.example.tickclickpick.ui.presentation.homeScreen.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FoodListViewModel(foodRepository = get()) }
}