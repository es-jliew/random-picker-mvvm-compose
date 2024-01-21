package com.essoft.randompicker.di

import com.essoft.randompicker.viewmodel.HomeViewModel
import com.essoft.randompicker.viewmodel.IHomeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind

val viewModelModule = module {
    viewModel { HomeViewModel(get()) } bind IHomeViewModel::class
}