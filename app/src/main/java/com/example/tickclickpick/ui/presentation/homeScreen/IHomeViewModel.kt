package com.example.tickclickpick.ui.presentation.homeScreen

import com.example.tickclickpick.model.FoodModel

interface IHomeViewModel {
    fun retrieveAllFood()

    fun createFood (foodModel: FoodModel)

    fun deleteFood(foodModel: FoodModel)

    fun createDemoFood()
}