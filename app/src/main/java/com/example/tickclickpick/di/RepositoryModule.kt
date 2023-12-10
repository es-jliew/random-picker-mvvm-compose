package com.example.tickclickpick.di

import com.example.tickclickpick.repo.FoodRepository
import com.example.tickclickpick.repo.IFoodRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IFoodRepository> { FoodRepository() }
}