package com.essoft.randompicker.viewmodel

import androidx.compose.runtime.MutableState
import com.essoft.randompicker.model.DialogState
import com.essoft.randompicker.model.FoodModel

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