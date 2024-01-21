package com.essoft.randompicker.di

import com.essoft.randompicker.repo.FoodRepository
import com.essoft.randompicker.repo.IFoodRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IFoodRepository> { FoodRepository() }
}