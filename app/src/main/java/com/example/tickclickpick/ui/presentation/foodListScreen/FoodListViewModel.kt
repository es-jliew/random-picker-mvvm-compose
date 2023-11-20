package com.example.tickclickpick.ui.presentation.foodListScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tickclickpick.model.FoodModel
import com.example.tickclickpick.repo.FoodRepository
import com.example.tickclickpick.repo.IFoodRepository
import kotlinx.coroutines.launch

class FoodListViewModel(private val foodRepository: IFoodRepository): ViewModel(){
    var foodModelList by mutableStateOf(emptyList<FoodModel>())

    fun retrieveAllFood() {
        viewModelScope.launch {
            foodRepository.retrieveAllFood().collect { response ->
               foodModelList = response
            }
        }
    }

    fun createFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.createFood(foodModel)
        }
    }

    fun deleteFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.deleteFood(foodModel)
        }
    }

    fun createDemoFood() {
        viewModelScope.launch {
            foodRepository.createDemoFood()
        }
    }
}