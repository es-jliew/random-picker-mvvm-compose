package com.example.tickclickpick.viewmodel

import androidx.compose.runtime.MutableState
import com.example.tickclickpick.model.DialogState
import com.example.tickclickpick.model.FoodModel

interface IHomeViewModel {
    fun retrieveAllFood()

    fun createFood ()

    fun deleteFood(foodModel: FoodModel)

    fun pickFood()

    fun getFoodList(): MutableState<List<FoodModel>>

    fun getDialogState(): MutableState<DialogState>

    fun resetDialogState()

    fun createDemoFood()

    fun updateFoodModel(updatedFoodModel: FoodModel)

    fun setFoodName(foodName: String)
}