package com.example.tickclickpick.viewmodel

import com.example.tickclickpick.model.FoodModel

interface IHomeViewModel {
    fun retrieveAllFood()

    fun createFood (foodModel: FoodModel)

    fun deleteFood(foodModel: FoodModel)

    fun getFoodList(): List<FoodModel>

    fun createDemoFood()

    fun upDateFoodModel(updatedFoodModel: FoodModel)
}