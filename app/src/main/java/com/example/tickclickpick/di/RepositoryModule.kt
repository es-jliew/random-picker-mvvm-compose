package com.example.tickclickpick.di

import com.example.tickclickpick.repo.FoodRepository
import com.example.tickclickpick.repo.IFoodRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    single { FoodRepository() } bind IFoodRepository::class
}