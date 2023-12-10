package com.example.tickclickpick.repo

import com.example.tickclickpick.model.FoodModel
import kotlinx.coroutines.flow.Flow

class FoodRepositoryMock: IFoodRepository {
    override suspend fun retrieveAllFood(): Flow<List<FoodModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun createFood(foodModel: FoodModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteFood(foodModel: FoodModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateFood(foodModel: FoodModel) {
        TODO("Not yet implemented")
    }

    override suspend fun createDemoFood() {
        TODO("Not yet implemented")
    }
}