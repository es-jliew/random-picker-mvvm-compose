package com.example.tickclickpick.repo

import com.example.tickclickpick.model.FoodModel
import kotlinx.coroutines.flow.Flow

interface IFoodRepository {
    suspend fun retrieveAllFood(): Flow<List<FoodModel>>

    suspend fun createFood(foodModel: FoodModel)

    suspend fun deleteFood(foodModel: FoodModel): Boolean

    suspend fun updateFood(foodModel: FoodModel)

    suspend fun createDemoFood()
}