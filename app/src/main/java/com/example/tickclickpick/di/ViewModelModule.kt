package com.example.tickclickpick.di

import com.example.tickclickpick.ui.presentation.foodListScreen.FoodListViewModel
import com.example.tickclickpick.ui.presentation.foodListScreen.IFoodListViewModel
import com.example.tickclickpick.ui.presentation.homeScreen.HomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { FoodListViewModel(get()) } bind IFoodListViewModel::class
}