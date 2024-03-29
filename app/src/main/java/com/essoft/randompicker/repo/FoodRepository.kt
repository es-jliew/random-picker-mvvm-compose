package com.essoft.randompicker.repo

import com.essoft.randompicker.db.ObjectBox
import com.essoft.randompicker.model.FoodModel
import io.objectbox.kotlin.toFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

class FoodRepository : IFoodRepository {
    private val foodModel1 = FoodModel(name = "Nasi Lemak", isChecked = true)
    private val foodModel2 = FoodModel(name = "Maggi Goreng", isChecked = false)
    private val foodModel3 = FoodModel(name = "Chicken Rice", isChecked = true)

    private val foodBox = ObjectBox.boxStore.boxFor(FoodModel::class.java)
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun retrieveAllFood(): Flow<List<FoodModel>> = foodBox.query().build().subscribe().toFlow()

    override suspend fun createFood(foodModel: FoodModel) {
        foodBox.put(foodModel)
    }

    override suspend fun deleteFood(foodModel: FoodModel): Boolean {
       return foodBox.remove(foodModel.id)
    }

    override suspend fun updateFood(foodModel: FoodModel) {
       foodBox.put(foodModel)
    }

    override suspend fun createDemoFood() {
        foodBox.put(foodModel1, foodModel2, foodModel3)
        //retrieveAllFood()
    }
}