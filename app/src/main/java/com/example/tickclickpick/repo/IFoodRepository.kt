package com.example.tickclickpick.repo

import com.example.tickclickpick.model.FoodModel
import kotlinx.coroutines.flow.Flow

interface IFoodRepository {
    suspend fun getAllFood(): Flow<List<FoodModel>>

    suspend fun addFood(foodModel: FoodModel)

    suspend fun deleteFood(foodModel: FoodModel)

    suspend fun updateFood(foodModel: FoodModel)
}