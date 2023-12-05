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

class FoodListViewModel(private val foodRepository: IFoodRepository): ViewModel(), IFoodListViewModel{
    var foodModelList by mutableStateOf(emptyList<FoodModel>())

    override fun retrieveAllFood() {
        viewModelScope.launch {
            foodRepository.retrieveAllFood().collect { response ->
               foodModelList = response
            }
        }
    }

    override fun createFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.createFood(foodModel)
        }
    }

    override fun deleteFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.deleteFood(foodModel)
        }
    }

    override fun createDemoFood() {
        viewModelScope.launch {
            foodRepository.createDemoFood()
        }
    }
}