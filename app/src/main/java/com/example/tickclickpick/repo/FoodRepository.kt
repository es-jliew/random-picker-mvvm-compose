package com.example.tickclickpick.repo

import com.example.tickclickpick.db.ObjectBox
import com.example.tickclickpick.model.FoodModel
import io.objectbox.kotlin.toFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

class FoodRepository : IFoodRepository {
    private val foodBox = ObjectBox.boxStore.boxFor(FoodModel::class.java)

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getAllFood(): Flow<List<FoodModel>> = foodBox.query().build().subscribe().toFlow()

    override suspend fun addFood(foodModel: FoodModel) {
        foodBox.put(foodModel)
    }

    override  suspend fun deleteFood(foodModel: FoodModel) {
        foodBox.remove(foodModel.id)
    }

    override suspend fun updateFood(foodModel: FoodModel) {
        foodBox.put(foodModel)
    }
}