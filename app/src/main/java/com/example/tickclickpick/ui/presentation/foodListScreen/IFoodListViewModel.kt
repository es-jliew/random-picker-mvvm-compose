package com.example.tickclickpick.ui.presentation.foodListScreen

import com.example.tickclickpick.model.FoodModel

interface IFoodListViewModel {
    fun retrieveAllFood()

    fun createFood (foodModel: FoodModel)

    fun deleteFood(foodModel: FoodModel)

    fun createDemoFood()
}