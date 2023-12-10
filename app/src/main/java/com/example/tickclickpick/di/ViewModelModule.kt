package com.example.tickclickpick.di

import com.example.tickclickpick.viewmodel.HomeViewModel
import com.example.tickclickpick.viewmodel.IHomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind

val viewModelModule = module {
    viewModel { HomeViewModel(get()) } bind IHomeViewModel::class
}