package com.example.tickclickpick.ui.presentation.foodListScreen

import com.example.tickclickpick.model.FoodModel

interface IFoodListViewModel {
    fun getAllFood()

    fun addFood(foodModel: FoodModel)

    fun removeFood(foodModel: FoodModel)
}