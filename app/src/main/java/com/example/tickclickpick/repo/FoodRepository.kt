package com.example.tickclickpick.repo

import com.example.tickclickpick.db.ObjectBox
import com.example.tickclickpick.model.FoodModel
import io.objectbox.kotlin.toFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

class FoodRepository : IFoodRepository {
    private val foodModel1 = FoodModel(name = "Test1", isChecked = true)
    private val foodModel2 = FoodModel(name = "Test2", isChecked = true)
    private val foodModel3 = FoodModel(name = "Test3", isChecked = true)

    private val foodBox = ObjectBox.boxStore.boxFor(FoodModel::class.java)
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun retrieveAllFood(): Flow<List<FoodModel>> = foodBox.query().build().subscribe().toFlow()

    override suspend fun createFood(foodModel: FoodModel) {
        foodBox.put(foodModel)
    }

    override suspend fun deleteFood(foodModel: FoodModel) {
        foodBox.remove(foodModel.id)
    }

    override suspend fun updateFood(foodModel: FoodModel) {
        foodBox.put(foodModel)
    }

    override suspend fun createDemoFood() {
        foodBox.put(foodModel1, foodModel2, foodModel3)
        //retrieveAllFood()
    }
}