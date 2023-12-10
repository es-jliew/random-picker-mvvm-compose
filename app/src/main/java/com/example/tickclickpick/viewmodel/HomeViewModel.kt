package com.example.tickclickpick.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tickclickpick.model.DbResult
import com.example.tickclickpick.model.FoodModel
import com.example.tickclickpick.repo.IFoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class HomeViewModel(private val foodRepository: IFoodRepository): ViewModel(), IHomeViewModel {
    private val _foodModelList = mutableStateOf(emptyList<FoodModel>())
    private val foodModelList: List<FoodModel> get() = _foodModelList.value

    override fun retrieveAllFood() {
        viewModelScope.launch(Dispatchers.IO)  {
            foodRepository.retrieveAllFood().collect { response ->
                updateFoodModelList(response)
            }
        }
    }

    override fun createFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.createFood(foodModel)
        }
    }

    override fun deleteFood(foodModel: FoodModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val dbResult = try {
                if (foodRepository.deleteFood(foodModel)) {
                    DbResult.Success
                } else {
                    DbResult.Failure("Failed to delete food.")
                }
            } catch (e: Exception) {
                DbResult.Failure("An error occurred: ${e.message}")
            }

            withContext(Dispatchers.Main) {
                handleDeleteFoodResult(dbResult)
            }
        }
    }

    override fun getFoodList(): List<FoodModel> {
        return foodModelList
    }

    override fun createDemoFood() {
        viewModelScope.launch {
            foodRepository.createDemoFood()
        }
    }

    override fun upDateFoodModel(updatedFoodModel: FoodModel) {
        _foodModelList.value.map { if (it.id == updatedFoodModel.id) {
            updatedFoodModel
        } else {
            it}
        }
    }

    private fun updateFoodModelList(newList: List<FoodModel>) {
        _foodModelList.value = newList
    }

    private fun handleDeleteFoodResult(dbResult: DbResult) {
        when (dbResult) {
            is DbResult.Success -> {
                // TODO: Handle success
                //retrieveAllFood()
            }
            is DbResult.Failure -> {
                // TODO: Handle failure
                // Access the error message with result.errorMessage
            }
        }
    }
}